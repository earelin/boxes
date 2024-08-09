package net.earelin.boxes.reader;

public class IntegerReader extends ValueReaderTemplate<Integer> {
    public IntegerReader(int start, int length) {
        super(start, length);
    }

    @Override
    protected Integer readColumnValue(String column) {
        return Integer.parseInt(column);
    }
}
