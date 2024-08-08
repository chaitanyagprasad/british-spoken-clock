package com.smartbear.chait.convertor;



import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultHourConvertorTest {

    private final DefaultHourConvertor fixture = new DefaultHourConvertor();

    @Test
    @DisplayName("Test default hour test")
    public void testConvert() {
        assertThat(
                fixture.convert(1)
        ).isEqualToIgnoringCase("one");

        assertThat(
                fixture.convert(12)
        ).isEqualToIgnoringCase("twelve");
    }
}