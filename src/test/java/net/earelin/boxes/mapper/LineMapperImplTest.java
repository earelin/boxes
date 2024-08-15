package net.earelin.boxes.mapper;

import lombok.Data;
import net.earelin.boxes.LineMapper;
import net.earelin.boxes.reader.type.TypeConverterFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;

class LineMapperImplTest {
    private static final String LINE = "000000387        John       Smith33";
    private static final String INCOMPLETE_LINE = "000000387        John";

    private TypeConverterFactory typeConverterFactory;

    private LineMapper lineMapper;

    @BeforeEach
    void setUp() {
        lineMapper = new LineMapperImpl(new TypeConverterFactory());
    }

    @Test
    void should_read_a_line() {
        assertThat(lineMapper.parseLine(LINE, MappedObject.class))
                .isNotNull()
                .extracting(
                        MappedObject::getId,
                        MappedObject::getName,
                        MappedObject::getSurname,
                        MappedObject::getAge)
                .containsExactly(387L, "John", "Smith", 33);
    }

    @ParameterizedTest
    @CsvSource(value = {"'   '"})
    @EmptySource
    @NullSource
    void should_return_null_on_empty_line(String line) {
        assertThat(lineMapper.parseLine(line, MappedObject.class))
                .isNull();
    }

    @Test
    void should_return_partial_result() {
        assertThat(lineMapper.parseLine(INCOMPLETE_LINE, MappedObject.class))
                .isNotNull()
                .extracting(
                        MappedObject::getId,
                        MappedObject::getName,
                        MappedObject::getSurname,
                        MappedObject::getAge)
                .containsExactly(387L, "John", null, null);
    }

    @Data
    static class MappedObject {
        @Column(length = 9)
        private Long id;
        @Column(start = 9, length = 12)
        private String name;
        @Column(start = 21, length = 12)
        private String surname;
        @Column(start = 33, length = 2)
        private Integer age;
    }
}
