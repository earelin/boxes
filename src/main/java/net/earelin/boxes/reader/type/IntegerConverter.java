package net.earelin.boxes.reader.type;

public class IntegerConverter implements TypeConverter<Integer> {
    @Override
    public Integer convert(String value) {
        return Integer.parseInt(value);
    }
}
