package net.earelin.boxes;

import net.earelin.boxes.mapper.LineMapperImpl;
import net.earelin.boxes.reader.type.TypeConverterFactory;

public final class LineMapperBuilder {
    public static LineMapper build() {
        var typeConverterFactory = new TypeConverterFactory();
        return new LineMapperImpl(typeConverterFactory);
    }

    private LineMapperBuilder() {}
}
