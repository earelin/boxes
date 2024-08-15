package net.earelin.boxes.reader.type;

import java.util.HashMap;
import java.util.Map;

public class TypeConverterFactory {
    private static final Map<Class<?>, TypeConverter<?>> PREDEFINED_CONVERTERS = Map.of(
            Boolean.class, new BooleanConverter(),
            String.class, new StringConverter(),
            Integer.class, new IntegerConverter(),
            Long.class, new LongConverter(),
            Float.class, new FloatConverter(),
            Double.class, new DoubleConverter()
    );

    private final Map<Class<?>, TypeConverter<?>> converters = new HashMap<>(PREDEFINED_CONVERTERS);

    public void add(Class<?> type, TypeConverter<?> converter) {
        converters.put(type, converter);
    }

    public TypeConverter<?> get(Class<?> type) {
        if (converters.containsKey(type)) {
            return converters.get(type);
        }
        throw new IllegalArgumentException("Unknown converter type: " + type);
    }
}
