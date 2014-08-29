package com.yambacode.solutions.euler56;

import com.yambacode.solutions.AbstractEulerSolver;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static com.yambacode.common.util.NumberStringConversions.bigIntegerToPrimitiveLongArray;
import static java.util.stream.Collectors.toList;

/**
 * http://projecteuler.net/problem=56
 * <p/>
 * Created by cbyamba on 2014-02-06.
 */
public class PowerfulDigitSum extends AbstractEulerSolver {

    public long digitSum(BigInteger number) {
        return LongStream.of(bigIntegerToPrimitiveLongArray(number)).sum();
    }

    public List<BigInteger> powers(BigInteger number) {
        return IntStream.range(1, 100).mapToObj(x -> number.pow(x)).collect(toList());
    }

    @Override
    public String doSolve() {
        return "" + IntStream.range(1, 100)
                .mapToObj(x -> BigInteger.valueOf(x))
                .flatMap(x -> powers(x).stream())
                .map(x -> digitSum(x))
                .max(Comparator.naturalOrder())
                .get();
    }

    public static void main(String... args) {
        new PowerfulDigitSum().solve();
    }
}
