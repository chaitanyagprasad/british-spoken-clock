package com.smartbear.chait.convertor;

import com.smartbear.chait.constant.*;
import org.junit.jupiter.api.*;


import static org.assertj.core.api.Assertions.assertThat;


public class MidnightConvertorTest {

    private final MidnightConvertor fixture = new MidnightConvertor();

    @Test
    @DisplayName("Test midnight convertor")
    public void testConvert() {
        assertThat(fixture.convert(1))
                .isEqualToIgnoringCase(TimeWordConstants.MIDNIGHT);

        assertThat(fixture.convert(100))
                .isEqualToIgnoringCase(TimeWordConstants.MIDNIGHT);

    }
}