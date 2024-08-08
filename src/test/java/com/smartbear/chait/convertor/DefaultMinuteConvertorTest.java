package com.smartbear.chait.convertor;

import com.smartbear.chait.constant.*;
import org.junit.jupiter.api.*;


import static org.assertj.core.api.Assertions.assertThat;


public class DefaultMinuteConvertorTest {

    private final DefaultMinuteConvertor fixture = new DefaultMinuteConvertor();

    @Test
    @DisplayName("Test default minute convertor")
    public void testConvert() {
        assertThat(
                fixture.convert(1)
        ).isEqualToIgnoringCase("one");

        assertThat(
                fixture.convert(15)
        ).isEqualToIgnoringCase(TimeWordConstants.MINUTES_15);

        assertThat(
                fixture.convert(30)
        ).isEqualToIgnoringCase(TimeWordConstants.MINUTES_30);
    }
}