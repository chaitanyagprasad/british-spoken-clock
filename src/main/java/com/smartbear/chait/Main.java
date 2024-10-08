package com.smartbear.chait;

import com.smartbear.chait.command.*;
import com.smartbear.chait.handlers.*;
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
        String[] splitNumbers = time.split(":");
        Integer hour = Integer.valueOf(splitNumbers[0]);
        Integer minutes = Integer.valueOf(splitNumbers[1]);

        BritishSpokenTimeHandlerChain handlerChain = new BritishSpokenTimeHandlerChain();
        handlerChain.addHandler(new MidnightHandler());
        handlerChain.addHandler(new NoonHandler());
        handlerChain.addHandler(new HourHandler());
        handlerChain.addHandler(new MinutesHandler());
        handlerChain.addHandler(new FormatHandler());

        BritishSpokenTimeCommand command = new BritishSpokenTimeCommand(hour, minutes);

        handlerChain.start(command);

        return command.getResult();
    }
}