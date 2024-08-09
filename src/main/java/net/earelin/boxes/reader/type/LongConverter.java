package net.earelin.boxes.reader.type;

public class LongConverter implements TypeConverter<Long> {
    @Override
    public Long convert(String value) {
        return Long.parseLong(value);
    }
}
