package net.earelin.boxes.reader;

public abstract class ValueReaderTemplate<T> implements ValueReader<T> {
    private final int start;
    private final int length;

    protected ValueReaderTemplate(int start, int length) {
        this.start = start;
        this.length = length;
    }

    public T readValue(String line) {
        String column = line.substring(start, start + length);
        return readColumnValue(column);
    }

    protected abstract T readColumnValue(String column);
}
