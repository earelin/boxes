package net.earelin.boxes.reader.type;

public class DoubleConverter implements TypeConverter<Double> {
    @Override
    public Double convert(String value) {
        return Double.parseDouble(value);
    }
}
