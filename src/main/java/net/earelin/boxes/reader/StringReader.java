package net.earelin.boxes.reader;

public class StringReader extends ValueReaderTemplate<String> {
    protected StringReader(int start, int length) {
        super(start, length);
    }

    @Override
    protected String readColumnValue(String column) {
        return column.trim();
    }
}
