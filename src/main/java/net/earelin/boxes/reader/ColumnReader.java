package net.earelin.boxes.reader;

import net.earelin.boxes.reader.type.TypeConverter;

public class ColumnReader<T> {
    private final int start;
    private final int length;
    private final TypeConverter<T> converter;

    public ColumnReader(int start, int length, TypeConverter<T> converter) {
        this.start = start;
        this.length = length;
        this.converter = converter;
    }

    public T readValue(String line) {
        String column = line.substring(start, start + length);
        return converter.convert(column);
    }
}
