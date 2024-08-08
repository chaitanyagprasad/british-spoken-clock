package com.smartbear.chait.util;


import com.smartbear.chait.constant.*;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;


public class TimeToWordConvertorTest {

    @Test
    @DisplayName("Test whether convert method works correctly for various inputs")
    public void testConvert() {
        assertThat(
                TimeToWordConvertor.convert(100)
        ).isEqualToIgnoringCase("one hundred");

        assertThat(
                TimeToWordConvertor.convert(1)
        ).isEqualToIgnoringCase("one");

        assertThat(
                TimeToWordConvertor.convert(15)
        ).isEqualToIgnoringCase("fifteen");

        assertThat(
                TimeToWordConvertor.convert(25)
        ).isEqualToIgnoringCase("twenty five");

    }

    @Test
    @DisplayName("Test whether the minutes convertor consumes time constants")
    public void testMinutesConvertor() {
        assertThat(
            TimeToWordConvertor.convertMinutes(0)
        ).isEqualToIgnoringCase(TimeWordConstants.MINUTES_0);

        assertThat(
                TimeToWordConvertor.convertMinutes(15)
        ).isEqualToIgnoringCase(TimeWordConstants.MINUTES_15);

        assertThat(
                TimeToWordConvertor.convertMinutes(30)
        ).isEqualToIgnoringCase(TimeWordConstants.MINUTES_30);
    }

    @Test
    @DisplayName("Test whether the minutes convertor converts values not having constant")
    void testMinutesConvertor_non_constant() {
        assertThat(
                TimeToWordConvertor.convertMinutes(45)
        ).isEqualToIgnoringCase("forty five");
        assertThat(
                TimeToWordConvertor.convertMinutes(12)
        ).isEqualToIgnoringCase("twelve");
    }


}