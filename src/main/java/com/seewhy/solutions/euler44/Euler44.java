package com.seewhy.solutions.euler44;

import com.seewhy.common.util.UpDownCastArrays;

import static com.seewhy.math.Numbers.*;

import com.seewhy.solutions.AbstractEulerSolver;

import java.util.Arrays;
import java.util.function.LongUnaryOperator;
import java.util.stream.LongStream;

/**
 * Created by cbyamba on 2014-01-24.
 */
public class Euler44 extends AbstractEulerSolver {

    protected long[] generateNGonalNumbers(long max, LongUnaryOperator operator) {
        return LongStream.range(1, max).map(operator).toArray();
    }

    public long[] generateNumbers() {
        long max = 100000;
        long[] triangular = generateNGonalNumbers(max, n -> triangularNumber(n));
        long[] pentagonal = generateNGonalNumbers(max, n -> pentagonalNumber(n));
        long[] heptagonal = generateNGonalNumbers(max, n -> heptagonalNumber(n));

        long[] merged = LongStream.concat(LongStream.of(triangular), LongStream.of(pentagonal)).toArray();
        return LongStream.concat(LongStream.of(merged), LongStream.of(heptagonal)).toArray();
    }

    @Override
    public String doSolve() {
        long[] numbers = generateNumbers();
        long[] sortedNumbers = LongStream.of(numbers).sorted().toArray();
        long[] founds = findNumbers(sortedNumbers);
        return Arrays.deepToString(UpDownCastArrays.upCast(founds));
    }

    private long[] findNumbers(long[] sortedNumbers) {
        long[] result = new long[sortedNumbers.length];
        for (int i = 0; i < result.length - 2; i++) {
            if (sortedNumbers[i] == sortedNumbers[i + 1] && sortedNumbers[i + 1] == sortedNumbers[i + 2]) {
                result[i] = sortedNumbers[i];
            }
        }
        return LongStream.of(result).filter(x -> x != 0).toArray();
    }
}
