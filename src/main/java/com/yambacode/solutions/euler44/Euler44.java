package com.yambacode.solutions.euler44;

import com.yambacode.common.collections.LongStreams;
import com.yambacode.common.collections.Streams;

import static com.yambacode.math.FigurativeNumbers.*;

import com.yambacode.solutions.AbstractEulerSolver;

import java.util.function.LongUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by cbyamba on 2014-01-24.
 */
public class Euler44 extends AbstractEulerSolver {

    private static final long MAX = 100000;

    protected LongStream generateNGonalNumberStream(long max, LongUnaryOperator... operators) {
        return LongStreams.concat(
                Streams.<LongUnaryOperator>of(operators)
                        .map(operator -> LongStream.range(1, max)
                                .map(operator))
                        .collect(Collectors.toList())
        );
    }

    public LongStream generateNumberStream() {
        return generateNGonalNumberStream(MAX,
                n -> triangularNumber(n),
                n -> pentagonalNumber(n),
                n -> heptagonalNumber(n)
        );
    }

    @Override
    public String doSolve() {
        return findNumbers(generateNumberStream().sorted().toArray())
                .boxed()
                .map(z -> "" + z)
                .collect(Collectors.joining(", "));
    }

    private LongStream findNumbers(long[] sortedNumbers) {
        long[] result = new long[sortedNumbers.length];
        IntStream.range(0, result.length - 2).forEach(
                i -> {
                    if (sortedNumbers[i] == sortedNumbers[i + 1] && sortedNumbers[i + 1] == sortedNumbers[i + 2]) {
                        result[i] = sortedNumbers[i];
                    }
                });
        return LongStream.of(result).filter(x -> x != 0);
    }

}
