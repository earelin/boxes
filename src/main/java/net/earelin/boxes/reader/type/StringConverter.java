package net.earelin.boxes.reader.type;

import static org.apache.commons.lang3.StringUtils.trim;

public class StringConverter implements TypeConverter<String> {
    @Override
    public String convert(String value) {
        return trim(value);
    }
}
