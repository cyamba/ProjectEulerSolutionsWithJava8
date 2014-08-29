package com.yambacode.solutions.euler55;

import com.yambacode.solutions.AbstractEulerSolver;

import java.math.BigInteger;

import static java.math.BigInteger.valueOf;
import static java.util.stream.IntStream.range;

/**
 * http://projecteuler.net/problem=55
 * <p/>
 * Created by cbyamba on 2014-02-06.
 */
public class LychrelNumbers extends AbstractEulerSolver {

    public boolean isLychrelNumber(BigInteger number) {
        return isLychrelNumber0(number, 0);
    }

    public boolean isLychrelNumber0(BigInteger number, int count) {
        if (count >= 50) {
            return true;
        }
        if (isPalindrome(number) && count > 0) {
            return false;
        }
        return isLychrelNumber0(number.add(reverseNumber(number)), ++count);
    }

    public BigInteger reverseNumber(BigInteger number) {
        return new BigInteger(reverse(number));
    }

    private String reverse(BigInteger number) {
        return new StringBuilder(number.toString()).reverse().toString();
    }

    public boolean isPalindrome(BigInteger number) {
        return reverse(number).equals(number.toString());
    }

    @Override
    public String doSolve() {
        return "" + range(1, 10000)
                .mapToObj(x -> valueOf(x))
                .filter(x -> isLychrelNumber(x))
                .count();
    }

    public static void main(String... args) {
        new LychrelNumbers().solve();
    }
}
