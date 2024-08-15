package net.earelin.boxes;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineMapperBuilderTest {
    @Test
    void should_build_line_mapper() {
        var lineMapper = LineMapperBuilder.builder().build();
        assertThat(lineMapper)
                .isNotNull();
    }
}
