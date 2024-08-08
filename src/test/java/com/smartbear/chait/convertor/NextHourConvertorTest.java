package com.smartbear.chait.convertor;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class NextHourConvertorTest {

    private final NextHourConvertor fixture = new NextHourConvertor();

    @Test
    @DisplayName("Test next hour conversion")
    public void testConvert() {
        assertThat(fixture.convert(1))
                .isEqualToIgnoringCase("two");

        assertThat(fixture.convert(12))
                .isEqualTo("one");
    }
}