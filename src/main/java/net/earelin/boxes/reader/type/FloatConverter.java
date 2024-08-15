package net.earelin.boxes.reader.type;

public class FloatConverter implements TypeConverter<Float> {
    @Override
    public Float convert(String value) {
        return Float.parseFloat(value);
    }
}
