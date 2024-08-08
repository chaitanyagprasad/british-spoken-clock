package com.smartbear.chait.formatter;

import com.smartbear.chait.constant.*;

/**
 * This class is there to give us the final formatted values for the hour and minutes
 */
public class TimeFormatter {

    /**
     *
     * @param hourInWords word equivalent if the hour component of the time
     * @param minutesInWords word equivalent if the minute component of the time
     * @param minutes Numerical value of minute
     * @return final British spoken time of the said time
     */
    public static String format(String hourInWords, String minutesInWords, Integer minutes) {
        if (hourInWords.equals(TimeWordConstants.MIDNIGHT)) {
            return minutesInWords + Fillers.PAST + TimeWordConstants.MIDNIGHT;
        }

        if (isHourMarker(minutes) && minutes <= 30) {
            return minutesInWords + Fillers.PAST + hourInWords;
        }

        if (isHourMarker(minutes)) {
            return minutesInWords + Fillers.TO + hourInWords;
        }

        if (isOneDigitMinutes(minutes)) {
            return hourInWords + Fillers.OH + minutesInWords;
        }

        // if not hour marker we need to say one thirty two
        return hourInWords + Fillers.WHITESPACE + minutesInWords;
    }

    /**
     *
     * @param minutes a minute value
     * @return whether the minutes is an hour marker equivalent
     */
    private static boolean isHourMarker(Integer minutes) {
        return minutes % 5 == 0 && minutes > 0;
    }

    private static boolean isOneDigitMinutes(Integer minutes) {
        return minutes > 0 && minutes < 10;
    }

}
