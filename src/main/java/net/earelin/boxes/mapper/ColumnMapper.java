package net.earelin.boxes.mapper;

import net.earelin.boxes.reader.ColumnReader;

import java.lang.reflect.Method;

public class ColumnMapper {
    private final ColumnReader<?> reader;
    private final Method setter;

    public ColumnMapper(ColumnReader<?> reader, Method setter) {
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
