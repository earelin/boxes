package net.earelin.boxes.reader.type;

public class BooleanConverter implements TypeConverter<Boolean> {
    @Override
    public Boolean convert(String value) {
        return Boolean.parseBoolean(value);
    }
}
