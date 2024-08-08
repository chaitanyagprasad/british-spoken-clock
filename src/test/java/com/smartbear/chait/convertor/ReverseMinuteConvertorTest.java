package com.smartbear.chait.convertor;

import com.smartbear.chait.constant.*;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseMinuteConvertorTest {

    private final ReverseMinuteConvertor fixture = new ReverseMinuteConvertor();
    @Test
    @DisplayName("Test non constant minute")
    public void testConvert() {

        assertThat(
                fixture.convert(1)
        ).isEqualToIgnoringCase("fifty nine");

    }

    @Test
    @DisplayName("Test constant minute value")
    void tc2() {
        assertThat(
                fixture.convert(
                        45
                )
        ).isEqualToIgnoringCase(TimeWordConstants.MINUTES_15);
    }
}