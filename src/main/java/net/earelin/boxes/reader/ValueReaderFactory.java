package net.earelin.boxes.reader;

public class ValueReaderFactory {
    public static ValueReader<?> createValueReader(Class<?> type, int start, int length) {
        return switch (type.getCanonicalName()) {
            case "java.lang.String" -> new StringReader(start, length);
            case "java.lang.Long" -> new LongReader(start, length);
            case "java.lang.Integer" -> new IntegerReader(start, length);
            default -> throw new IllegalArgumentException("Unsupported type: " + type);
        };
    }
}
