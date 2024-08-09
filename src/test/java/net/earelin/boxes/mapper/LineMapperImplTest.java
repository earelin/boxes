package net.earelin.boxes.mapper;

import lombok.Data;
import net.earelin.boxes.LineMapper;
import net.earelin.boxes.reader.type.TypeConverterFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineMapperImplTest {
    private static final String LINE = "000000387        John       Smith33";

    private TypeConverterFactory typeConverterFactory;

    private LineMapper lineMapper;

    @BeforeEach
    void setUp() {
        lineMapper = new LineMapperImpl(new TypeConverterFactory());
    }

    @Test
    void should_read_a_line() {
        assertThat(lineMapper.readLine(LINE, MappedObject.class))
                .isNotNull()
                .extracting(
                        MappedObject::getId,
                        MappedObject::getName,
                        MappedObject::getSurname,
                        MappedObject::getAge)
                .containsExactly(387L, "John", "Smith", 33);
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
