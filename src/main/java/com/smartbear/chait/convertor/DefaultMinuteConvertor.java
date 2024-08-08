package com.smartbear.chait.convertor;

import com.smartbear.chait.util.*;

/**
 * This class is used for default minute conversions
 */
public class DefaultMinuteConvertor extends BaseTimeConvertor{
    @Override
    public String convert(Integer input) {
        return TimeToWordConvertor.convertMinutes(input);
    }
}
