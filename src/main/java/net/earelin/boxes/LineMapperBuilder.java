package net.earelin.boxes;

import net.earelin.boxes.mapper.LineMapperImpl;
import net.earelin.boxes.reader.type.TypeConverterFactory;

/**
 * The LineMapperBuilder class is a builder for creating instances of LineMapper.
 * It allows you to customize the LineMapper.
 */
public class LineMapperBuilder {
    public static LineMapperBuilder builder() {
        return new LineMapperBuilder(new TypeConverterFactory());
    }

    private final TypeConverterFactory typeConverterFactory;

    public LineMapper build() {
        return new LineMapperImpl(typeConverterFactory);
    }

    private LineMapperBuilder(TypeConverterFactory typeConverterFactory) {
        this.typeConverterFactory = typeConverterFactory;
    }
}
