package com.smartbear.chait.convertor;

import com.smartbear.chait.constant.*;

/**
 * This class is used if the hour identified is 0
 */
public class MidnightConvertor extends BaseTimeConvertor{
    @Override
    public String convert(Integer input) {
        return TimeWordConstants.MIDNIGHT;
    }
}
