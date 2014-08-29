package com.yambacode.experiments;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-03-08.
 */
public class MathProblem91 extends AbstractEulerSolver {
    @Override
    public String doSolve() {
        Map<Integer, Long> collect = IntStream.rangeClosed(1, 10000)
                .parallel()
                .mapToObj(x -> BigInteger.valueOf(2).pow(x))
                .map(this::firstDigit)
                .collect(Collectors.groupingBy(Function.<Integer>identity(), Collectors.counting()));
        return Arrays.deepToString(collect.entrySet().toArray());

    }

    public Integer firstDigit(BigInteger number) {
        return Integer.valueOf(number.toString().substring(0,1));
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new MathProblem91());
    }
}
