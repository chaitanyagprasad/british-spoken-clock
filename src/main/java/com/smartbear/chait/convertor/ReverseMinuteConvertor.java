package com.smartbear.chait.convertor;

import com.smartbear.chait.util.*;

/**
 * The minutes need to be reversed if it crosses 35
 */
public class ReverseMinuteConvertor extends BaseTimeConvertor{
    @Override
    public String convert(Integer input) {
        return TimeToWordConvertor.convertMinutes(60 - input);
    }
}
