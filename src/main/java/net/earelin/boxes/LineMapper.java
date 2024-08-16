package net.earelin.boxes;

/**
 * The LineMapper interface represents a contract for mapping a line of data to an object of the specified type.
 * Implementations of this interface are responsible for parsing the input line and populating the object with the extracted data.
 */
public interface LineMapper {
    /**
     * Reads a line and create and object based on the type parameter annotations.
     * @param line The line to be parsed
     * @param type An annotated class
     * @return Object with the read values
     */
    <T> T parseLine(String line, Class<T> type);
}
