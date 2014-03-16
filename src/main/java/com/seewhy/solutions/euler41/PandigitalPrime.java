package com.seewhy.solutions.euler41;

import static com.seewhy.common.util.NumberStringConversions.*;
import static com.seewhy.math.Primes.*;

import com.seewhy.solutions.AbstractEulerSolver;

import java.util.stream.IntStream;

/**
 * http://projecteuler.net/problem=41
 * <p/>
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once.
 * For example, 2143 is a 4-digit pandigital and is also prime.
 * <p/>
 * What is the largest n-digit pandigital prime that exists?
 * <p/>
 * Answer:7652413
 * Created by cbyamba on 2014-01-23.
 */
public class PandigitalPrime extends AbstractEulerSolver {

    private static final int MAX = 987654321;

    public boolean isPandigital(Integer number) {
        int[] digits = intToIntArray(number);
        int length = number.toString().length();
        return IntStream.of(digits).distinct().filter(x -> x == 0).sum() == length * (length + 1) / 2;
    }

    @Override
    public String doSolve() {
        int i = MAX;
        Integer panDigitalPrime = null;
        while (i > 2) {
            if (isPrime(i)) {
                if (isPandigital(i)) {
                    return "" + i;
                }
            }
            i -= 2;
        }
        return null;
    }
}
