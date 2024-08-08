package com.smartbear.chait.convertor;

import com.smartbear.chait.util.*;

/**
 * This strategy will used when the minute time is past 35 minutes.
 */
public class NextHourConvertor extends BaseTimeConvertor {
    @Override
    public String convert(Integer input) {
        input += 1;
        return input == 13 ? TimeToWordConvertor.convert(13 % 12) : TimeToWordConvertor.convert(input);
    }
}
