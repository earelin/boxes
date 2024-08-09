package net.earelin.boxes.reader;

public interface ValueReader<T> {
    T readValue(String line);
}
