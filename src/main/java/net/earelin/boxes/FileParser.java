package net.earelin.boxes;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * The FileParser interface is responsible for parsing a file and returning a list of objects of type T.
 * It provides a method to parse an input stream and transform it into a list of objects.
 *
 * @param <T> The type of objects to be parsed from the file.
 */
public interface FileParser<T> {
    List<T> parse(InputStream inputStream, Class<T> clazz) throws IOException;
}
