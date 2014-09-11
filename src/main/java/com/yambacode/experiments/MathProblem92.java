package com.yambacode.experiments;

import com.yambacode.math.FigurativeNumbers;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by cbyamba on 2014-03-08.
 */
public class MathProblem92 extends AbstractEulerSolver {
    @Override
    public String doSolve() {
        Map<Integer, Long> result = FigurativeNumbers.fibbo(10000, new BigInteger[]{BigInteger.ONE, BigInteger.ONE})
                .parallelStream()
                .map(this::firstDigit
                )
                .collect(Collectors.groupingBy(Function.<Integer>identity(), Collectors.counting()));
        return Arrays.deepToString(result.entrySet().toArray());
    }

    protected Integer firstDigit(BigInteger number) {
        return Integer.valueOf(number.toString().substring(0, 1));
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new MathProblem92());
    }
}
