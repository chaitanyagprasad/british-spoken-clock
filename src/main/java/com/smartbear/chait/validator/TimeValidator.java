package com.smartbear.chait.validator;

import java.util.regex.*;

/**
 * This class is used to validate whether the time input by the user is correct or not
 */
public class TimeValidator {
    private static final Pattern pattern = Pattern.compile("^(1[0-2]|0?\\d):([0-5]?\\d)?$");
    public static boolean isValidFormat(String time) {
        Matcher matcher = pattern.matcher(time);
        return matcher.matches();
    }
}
