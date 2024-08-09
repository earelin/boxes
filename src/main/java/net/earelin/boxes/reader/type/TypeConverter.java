package net.earelin.boxes.reader.type;

public interface TypeConverter<T> {
    T convert(String value);
}
