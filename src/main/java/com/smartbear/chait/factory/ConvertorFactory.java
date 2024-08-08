package com.smartbear.chait.factory;

import com.smartbear.chait.convertor.*;

/**
 * Factory class used to generate convertor classes based on the inputs.
 */
public class ConvertorFactory {

    public static BaseTimeConvertor hourConvertor(Integer hour, Integer minutes) {
        BaseTimeConvertor resp;
        if( isNextHourProcessing(minutes) ) {
            resp = new NextHourConvertor();
        } else if (hour == 0) {
            resp = new MidnightConvertor();
        }else {
            resp = new DefaultHourConvertor();
        }
        return resp;

    }

    public static BaseTimeConvertor minutesConvertor(Integer minutes) {
        return isNextHourProcessing(minutes) ? new ReverseMinuteConvertor() : new DefaultMinuteConvertor();
    }

    private static boolean isNextHourProcessing(Integer min) {
        return min > 30 && min % 5 == 0;
    }

}
