package com.smartbear.chait.factory;

import com.smartbear.chait.convertor.*;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ConvertorFactoryTest {


    @Test
    @DisplayName("Test whether the factory initialized MidnightConvertor")
    public void testHourConvertor_midnight_convertor() {
        assertThat(
                ConvertorFactory.hourConvertor(0, 0)
        ).isExactlyInstanceOf(MidnightConvertor.class);
    }

    @Test
    @DisplayName("Test whether the factory initialized NextHourConvertor")
    public void testHourConvertor_nexthour_convertor() {

        assertThat(
                ConvertorFactory.hourConvertor(1, 45)
        ).isExactlyInstanceOf(NextHourConvertor.class);

    }

    @Test
    @DisplayName("Test whether the factory initialized DefaultHourConvertor")
    public void testHourConvertor_default_convertor() {

        assertThat(
                ConvertorFactory.hourConvertor(1, 15)
        ).isExactlyInstanceOf(DefaultHourConvertor.class);

    }

    @Test
    @DisplayName("Test whether the factory initialized ReverseMinuteConvertor")
    public void testMinuteConvertor_reverse_minute() {
        assertThat(
                ConvertorFactory.minutesConvertor(45)
        ).isExactlyInstanceOf(ReverseMinuteConvertor.class);


    }

    @Test
    @DisplayName("Test whether the factory initialized DefaultMinuteConvertor")
    public void testMinuteConvertor_default_minute() {
        assertThat(
                ConvertorFactory.minutesConvertor(15)
        ).isExactlyInstanceOf(DefaultMinuteConvertor.class);
    }


}

