package com.smartbear.chait.convertor;

import com.smartbear.chait.util.*;

/**
 * This class will be used if the hour is not midnight and there is no next hour conversion required
 */
public class DefaultHourConvertor extends BaseTimeConvertor {
    @Override
    public String convert(Integer input) {
        return TimeToWordConvertor.convert(input);
    }
}
