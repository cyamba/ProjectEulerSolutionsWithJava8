package com.yambacode.solutions.euler22;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cbyamba on 2014-09-18.
 */
public class WordsUtil {
    private static Map<Character, Short> alphabethMap = new HashMap<Character, Short>();


    public static BigInteger getAlphabeticSum(String name) {
        int sum = 0;
        for (char c : name.toCharArray()) {
            sum += c - 64;
        }
        return BigInteger.valueOf((long) sum);
    }
}
