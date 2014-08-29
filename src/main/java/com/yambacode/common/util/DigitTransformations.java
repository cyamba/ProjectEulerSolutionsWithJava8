package com.yambacode.common.util;

import com.yambacode.math.Primes;

import java.util.List;

import static java.util.stream.Collectors.*;

import java.util.stream.IntStream;

import static com.yambacode.common.util.NumberStringConversions.intArrayToInt;
import static com.yambacode.common.util.NumberStringConversions.intToIntArray;
import static java.util.Arrays.copyOf;

/**
 * Created by cbyamba on 2014-02-20.
 */
public class DigitTransformations {

    public static Integer replaceWith(final Integer originalNumber, final int[] positions, final int value) {
        int[] digits = intToIntArray(originalNumber);
        int[] newDigits = copyOf(digits, digits.length);
        //mutate local newDigits replacing positions with value
        IntStream.range(0, positions.length).forEach(i -> newDigits[positions[i]] = value);
        return intArrayToInt(newDigits);
    }

    public static List<Integer> replaceDigitsWith0To9(final Integer originalNumber, final int[] positions) {
        return IntStream
                .range(0, 10)
                .parallel()
                .map(i -> DigitTransformations.replaceWith(originalNumber, positions, i))
                .boxed()
                .filter(j -> j.toString().length() == originalNumber.toString().length())
                .filter(Primes::isPrime)
                .collect(toList());
    }


}
