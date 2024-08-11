package net.earelin.boxes.mapper;

import net.earelin.boxes.LineMapper;
import net.earelin.boxes.reader.ColumnReader;
import net.earelin.boxes.reader.type.TypeConverterFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class LineMapperImpl implements LineMapper {

    private final Map<String, List<ColumnMapper>> columnMappersCache = new HashMap<>();
    private final TypeConverterFactory typeConverterFactory;

    public LineMapperImpl(TypeConverterFactory typeConverterFactory) {
        this.typeConverterFactory = typeConverterFactory;
    }

    @Override
    public <T> T parseLine(String line, Class<T> type) {
        T object = createObject(type);

        var columnMappers = getColumnMappers(type);
        columnMappers.forEach(columnMapper -> columnMapper.setValue(line, object));

        return object;
    }

    private <T> T createObject(Class<T> type) {
        try {
            var constructor = type.getConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException e) {
            throw new TargetClassException("Target class must have an empty constructor.", e);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new TargetClassException("Could not instantiate target class", e);
        }
    }

    private <T> List<ColumnMapper> getColumnMappers(Class<T> type) {
        final var canonicalName = type.getCanonicalName();

        if (!columnMappersCache.containsKey(canonicalName)) {
            columnMappersCache.put(canonicalName, Arrays.stream(type.getDeclaredFields())
                    .filter(field -> field.isAnnotationPresent(Column.class))
                    .map(buildColumnMapper(type))
                    .toList());

        }

        return columnMappersCache.get(canonicalName);
    }

    private <T> Function<Field, ColumnMapper> buildColumnMapper(Class<T> type) {
        return field -> {
            var column = field.getAnnotation(Column.class);
            var typeConverter = typeConverterFactory.get(field.getType());
            var columnReader = new ColumnReader<>(column.start(), column.length(), typeConverter);
            var setter = getFieldSetter(type, field);
            return new ColumnMapper(columnReader, setter);
        };
    }

    private Method getFieldSetter(Class<?> type, Field field) {
        var methodName = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
        try {
            return type.getMethod(methodName, field.getType());
        } catch (NoSuchMethodException e) {
            throw new TargetClassException("Could not find setter for field " + field.getName(), e);
        }
    }
}
