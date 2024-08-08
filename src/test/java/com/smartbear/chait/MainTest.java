package com.smartbear.chait;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;


public class MainTest {
    @Test
    @DisplayName("Test whether h:00 and hh:00 conversion happens")
    public void tc1() {
        assertThat(
                Main.convert("1:00")
        ).isEqualToIgnoringCase("one o'clock");
        assertThat(
                Main.convert("01:00")
        ).isEqualToIgnoringCase("one o'clock");

        assertThat(
                Main.convert("8:00")
        ).isEqualToIgnoringCase("eight o'clock");
    }

    @Test
    @DisplayName("Test whether minute value is an hour marker less than 30 shows expected results")
    void tc2() {
        assertThat(
                Main.convert("2:05")
        ).isEqualToIgnoringCase("five past two");

        assertThat(
                Main.convert("3:10")
        ).isEqualToIgnoringCase("ten past three");

        assertThat(
                Main.convert("4:15")
        ).isEqualToIgnoringCase("quarter past four");

        assertThat(
                Main.convert("5:20")
        ).isEqualToIgnoringCase("twenty past five");

        assertThat(
                Main.convert("6:25")
        ).isEqualToIgnoringCase("twenty five past six");
    }

    @Test
    @DisplayName("Test when hour is 0")
    void tc3() {
        assertThat(
                Main.convert("0:25")
        ).isEqualToIgnoringCase("twenty five past midnight");
    }

    @Test
    @DisplayName("Test when minutes is greater than 30 and it is a hour marker")
    void tc4() {
        assertThat(
                Main.convert("0:35")
        ).isEqualToIgnoringCase("twenty five to one");

        assertThat(
                Main.convert("08:40")
        ).isEqualToIgnoringCase("twenty to nine");
    }

    @Test
    @DisplayName("Test minutes is not hour marker and less than 30")
    void tc5() {

        assertThat(
                Main.convert("1:12")
        ).isEqualToIgnoringCase("one twelve");

        assertThat(
                Main.convert("08:24")
        ).isEqualToIgnoringCase("eight twenty four");
    }

    @Test
    @DisplayName("Test minutes less than ten")
    void tc6() {
        assertThat(
                Main.convert("1:02")
        ).isEqualToIgnoringCase("one oh two");

        assertThat(
                Main.convert("08:09")
        ).isEqualToIgnoringCase("eight oh nine");
    }

    @Test
    @DisplayName("Test whether noon conversion happens")
    void tc7() {
        assertThat(
                Main.convert("12:00")
        ).isEqualToIgnoringCase("noon");
    }
}