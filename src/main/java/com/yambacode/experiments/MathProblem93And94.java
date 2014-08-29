package com.yambacode.experiments;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.ToLongFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.yambacode.common.util.NumberStringConversions.bigIntegerToIntegerList;
import static java.util.stream.Collectors.joining;

/**
 * Created by cbyamba on 2014-03-09.
 */
public class MathProblem93And94 extends AbstractEulerSolver {

    //Problem 93
    public static ToLongFunction<Integer> toSquare = x -> x * x;
    //Problem 94
    public static ToLongFunction<Integer> toCube = x -> x * x * x;

    @Override
    public String doSolve() {
        return Stream.of(toSquare, toCube)
                .parallel()
                .map(function -> computeSolution(function))
                .collect(joining("\n"));
    }

    protected String computeSolution(ToLongFunction<Integer> function) {
        return IntStream.rangeClosed(100, 999)
                .parallel()
                .mapToObj(x ->
                        sequence(x, 100, function)
                                .stream()
                                .map(i -> i.toString())
                                .collect(joining(",")))
                .collect(joining("\n"));
    }

    protected List<BigInteger> sequence(Integer number, Integer length, ToLongFunction<Integer> function) {
        List<BigInteger> result = new ArrayList<>(length);
        BigInteger start = BigInteger.valueOf(number);
        result.add(start);
        int count = 0;
        while (count < length) {
            count++;
            result.add(sumOfMappedDigits(result.get(result.size() - 1), function));
        }
        return result;
    }

    protected BigInteger sumOfMappedDigits(BigInteger number, ToLongFunction<Integer> function) {
        return BigInteger.valueOf(
                bigIntegerToIntegerList(number)
                        .parallelStream()
                        .mapToLong(function)
                        .sum());

    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new MathProblem93And94());
    }
}
