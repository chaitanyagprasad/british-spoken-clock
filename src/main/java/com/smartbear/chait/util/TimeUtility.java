package com.smartbear.chait.util;

public class TimeUtility {
    public static boolean isNextHourProcessing(Integer min) {
        return min > 30 && min % 5 == 0;
    }
}
