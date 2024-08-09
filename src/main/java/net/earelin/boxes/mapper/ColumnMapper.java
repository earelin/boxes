package net.earelin.boxes.mapper;

import net.earelin.boxes.reader.ValueReader;

import java.lang.reflect.Method;

public class ColumnMapper {
    private final ValueReader<?> reader;
    private final Method setter;

    public ColumnMapper(ValueReader<?> reader, Method setter) {
        this.reader = reader;
        this.setter = setter;
    }

    public void setValue(String line, Object target) {
        Object value = reader.readValue(line);
        try {
            setter.invoke(target, value);
        } catch (Exception e) {
            throw new TargetClassException("Error setting value", e);
        }
    }
}
