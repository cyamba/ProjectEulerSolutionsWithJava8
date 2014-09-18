package com.yambacode.solutions.euler36;

/**
 * Created by cbyamba on 2011-12-03
 */
public class DigitUtil {


    public static Integer palindromize(Integer number) {

        if (number.toString().length() > 8)
            throw new IllegalArgumentException(number + " is has too many digits. maximum digits is 8");

        String s1 = number.toString();
        String s2 = new StringBuilder().append(number).reverse().toString();
        String s3 = s1 + s2;
        System.out.println(s3 + " " + Integer.toBinaryString(Integer.valueOf(s3)));
        return Integer.valueOf(s3);
    }

    public static String getReverse(Integer number) {
        return new StringBuilder().append(number.toString()).reverse().toString();
    }

    public static String getReverse(String string) {
        return new StringBuilder().append(string).reverse().toString();
    }

    public static boolean isPalindrome(String string) {
        return new StringBuilder(string).reverse().toString().equals(string);
    }

    public static String collapseMiddleOfPalindrome(String palindrome) {
        if (!isPalindrome(palindrome))
            throw new IllegalArgumentException(palindrome + " is not a palindrome");
        if (!(palindrome.length() % 2 == 0))
            throw new IllegalArgumentException(palindrome + " does not have same two digits in the middle ");
        if (palindrome.length() == 2) {
            return palindrome.substring(0, 1);
        }
        String s = palindrome.substring(0, palindrome.length() / 2) +
                palindrome.charAt(palindrome.length() / 2 + 1) +
                palindrome.substring(palindrome.length() / 2 + 2);
        System.out.println(s + " " + Integer.toBinaryString(Integer.valueOf(s)));
        return s;
    }
}
