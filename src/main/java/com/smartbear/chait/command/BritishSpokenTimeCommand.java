package com.smartbear.chait.command;

public class BritishSpokenTimeCommand {

    private Integer hour;

    private Integer minutes;

    private String hourInWords;

    private String minutesInWords;

    private String result;

    public BritishSpokenTimeCommand(int hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public String getHourInWords() {
        return hourInWords;
    }

    public void setHourInWords(String hourInWords) {
        this.hourInWords = hourInWords;
    }

    public String getMinutesInWords() {
        return minutesInWords;
    }

    public void setMinutesInWords(String minutesInWords) {
        this.minutesInWords = minutesInWords;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
