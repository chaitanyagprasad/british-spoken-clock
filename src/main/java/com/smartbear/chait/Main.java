package com.smartbear.chait;

import com.smartbear.chait.constant.*;
import com.smartbear.chait.convertor.*;
import com.smartbear.chait.factory.*;
import com.smartbear.chait.formatter.*;
import com.smartbear.chait.validator.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Please enter time in range 00:00-12:59 with the format HH:MM => ");
                String input = scanner.nextLine().trim();

                if (input.equals(":q!")) break;

                if (TimeValidator.isValidFormat(input)) {
                    System.out.println(convert(input));
                } else {
                    System.out.println("Error: The system accepts input as 00:00-12:59 with the format HH:MM. ");
                }
            }
        }
    }

    public static String convert(String time) {
        // base cases
        if (time.equals("12:00")) return TimeWordConstants.NOON;
        if (time.equals("00:00") || time.equals("0:00")) return TimeWordConstants.MIDNIGHT;

        String[] splitNumbers = time.split(":");
        Integer hour = Integer.valueOf(splitNumbers[0]);
        Integer minutes = Integer.valueOf(splitNumbers[1]);

        BaseTimeConvertor hourConvertor = ConvertorFactory.hourConvertor(hour, minutes);
        BaseTimeConvertor minutesConvertor = ConvertorFactory.minutesConvertor(minutes);

        String hourAsSpokenWord = hourConvertor.convert(hour);
        String minutesAsSpokenWord = minutesConvertor.convert(minutes);

        return TimeFormatter.format(hourAsSpokenWord, minutesAsSpokenWord, minutes);
    }
}