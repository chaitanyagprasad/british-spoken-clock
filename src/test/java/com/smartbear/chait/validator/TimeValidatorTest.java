package com.smartbear.chait.validator;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;


public class TimeValidatorTest {

    @Test
    @DisplayName("00:00 is valid")
    public void tc1() {
        assertThat(
                TimeValidator.isValidFormat("00:00")
        ).isTrue();
    }

    @Test
    @DisplayName("11:45 is valid")
    void tc2() {
        assertThat(
                TimeValidator.isValidFormat("11:45")
        ).isTrue();
    }

    @Test
    @DisplayName("45:11 is invalid")
    void tc3() {
        assertThat(
                TimeValidator.isValidFormat("45:11")
        ).isFalse();
    }

    @Test
    @DisplayName("60:60 is invalid")
    void tc4() {
        assertThat(
                TimeValidator.isValidFormat("60:60")
        ).isFalse();
    }
}