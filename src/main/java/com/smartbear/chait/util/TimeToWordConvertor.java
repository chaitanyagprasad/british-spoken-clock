package com.smartbear.chait.util;

import com.smartbear.chait.constant.*;
import pl.allegro.finance.tradukisto.*;

/**
 * Conversion utility to convert time into string
 */
public class TimeToWordConvertor {

    private static final ValueConverters integerConvertor = ValueConverters.ENGLISH_INTEGER;

    /**
     *
     * @param minutes Numerical value of minutes
     * @return a string which is the British spoken equivalent of the minutes.
     */
    public static String convertMinutes(Integer minutes) {
        String minutesInWords;

        switch (minutes){
            case 0:
                minutesInWords = TimeWordConstants.MINUTES_0;
                break;
            case 15:
                minutesInWords = TimeWordConstants.MINUTES_15;
                break;
            case 30:
                minutesInWords = TimeWordConstants.MINUTES_30;
                break;
            default:
                minutesInWords = convert(minutes);
                break;
        }
        return minutesInWords;
    }

    /**
     *
     * @param val any number that needs conversion to words.
     * @return Spoken equivalent of the given number.
     */
    public static String convert(Integer val) {
        return integerConvertor.asWords(val)
                .replace("-"," ");
    }

}
