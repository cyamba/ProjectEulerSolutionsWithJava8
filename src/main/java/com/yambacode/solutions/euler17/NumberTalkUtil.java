package com.yambacode.solutions.euler17;

import java.util.HashMap;

/**
 * Created by cbyamba on 2011-11-20
 */
public class NumberTalkUtil {

    private static HashMap<Integer, String> upToTen = new HashMap<Integer, String>();

    static {
        upToTen.put(0, "");
        upToTen.put(1, "one");
        upToTen.put(2, "two");
        upToTen.put(3, "three");
        upToTen.put(4, "four");
        upToTen.put(5, "five");
        upToTen.put(6, "six");
        upToTen.put(7, "seven");
        upToTen.put(8, "eight");
        upToTen.put(9, "nine");
        upToTen.put(10, "ten");
    }

    private static HashMap<Integer, String> between11And19 = new HashMap<Integer, String>();

    static {
        between11And19.put(11, "eleven");
        between11And19.put(12, "twelve");
        between11And19.put(13, "thirteen");
        between11And19.put(14, "fourteen");
        between11And19.put(15, "fifteen");
        between11And19.put(16, "sixteen");
        between11And19.put(17, "seventeen");
        between11And19.put(18, "eighteen");
        between11And19.put(19, "nineteen");
    }


    private static HashMap<Integer, String> between20And90 = new HashMap<Integer, String>();

    static {
        between20And90.put(2, "twenty");
        between20And90.put(3, "thirty");
        between20And90.put(4, "forty");
        between20And90.put(5, "fifty");
        between20And90.put(6, "sixty");
        between20And90.put(7, "seventy");
        between20And90.put(8, "eighty");
        between20And90.put(9, "ninety");
    }


    public static String StringByCount(Integer count) {
        if (count < 100) {
            return getUnderAHundred(count);
        }
        if (count >= 100 && count <= 999) {
            return getHundred(count);
        }
        if (count == 1000) {
            return getThousand();
        }
        throw new IllegalArgumentException();
    }

    private static String getBetween1And10(Integer count) {
        return upToTen.get(count);
    }

    private static String getBetween11And19(Integer count) {
        return between11And19.get(count);
    }

    private static String getBetween20And99(Integer count) {
        return between20And90.get(count);
    }

    private static String getUnderAHundred(int count) {
        if (count <= 10) {
            return getBetween1And10(count);
        }
        if (count >= 11 && count <= 19) {
            return getBetween11And19(count);
        }
        if (count >= 20 && count <= 99) {
            return getBetween20And99(count / 10) + getBetween1And10(count % 10);
        }
        throw new IllegalArgumentException();
    }

    private static String getHundred(Integer count) {

        String value = getBetween1And10(count / 100);
        String hundred = "hundred";

        return (count % 100 != 0) ? new StringBuilder()
                .append(value)
                .append(hundred)
                .append("and")
                .append(getUnderAHundred(count % 100)).toString() :
                (new StringBuilder()
                        .append(value)
                        .append(hundred).toString());
    }

    private static String getThousand() {
        return "one" + "thousand";
    }
}



