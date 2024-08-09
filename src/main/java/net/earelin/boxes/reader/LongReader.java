package net.earelin.boxes.reader;

public class LongReader extends ValueReaderTemplate<Long> {
    protected LongReader(int start, int length) {
        super(start, length);
    }

    @Override
    protected Long readColumnValue(String column) {
        return Long.parseLong(column);
    }
}
