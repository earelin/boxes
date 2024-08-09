package net.earelin.boxes;

public interface LineMapper {
    <T> T readLine(String line, Class<T> type);
}
