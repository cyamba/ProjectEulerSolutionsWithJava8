package com.yambacode.math;

import java.util.List;

/**
 * Created by cbyamba on 2014-09-17.
 */
public class Products {

    public static Number productOf(int... numbers) {
        int result = 1;
        for (Number number : numbers) {
            if (number.intValue() == 0) {
                return 0;
            }
            result *= number.intValue();
        }
        return result;
    }

    public static Number productOf(String numberString) {

        int result = 1;

        if (numberString == null || numberString.equals("") || numberString.length() != 5)
            return result;

        for (int i = 0; i < numberString.length(); i++) {
            if (Integer.parseInt(numberString.charAt(i) + "") == 0) {
                return 0;
            }
            result *= Integer.parseInt((numberString.charAt(i) + ""));
        }
        return result;
    }

    public static Number numberOfPrimeFactors(List<Integer> primeFactors) {
        Integer number = 1;
        for (Integer factorCount : primeFactors) {
            number *= (factorCount + 1);
        }
        return number;
    }
}

