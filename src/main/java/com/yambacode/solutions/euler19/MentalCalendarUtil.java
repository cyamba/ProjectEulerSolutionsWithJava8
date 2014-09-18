package com.yambacode.solutions.euler19;

/**
 * Created by cbyamba on 2011-11-23
 */
public class MentalCalendarUtil {

    public static boolean isLeapYear(int number) {
        if (number % 100 == 0) {
            return number % 400 == 0;
        }
        return number % 4 == 0;
    }

}
