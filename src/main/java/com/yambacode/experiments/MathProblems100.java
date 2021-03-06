package com.yambacode.experiments;

import com.yambacode.common.util.NumberStringConversions;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.util.Arrays;
import java.util.stream.LongStream;

/**
 * Created by cbyamba on 2014-03-08.
 */
public class MathProblems100 extends AbstractEulerSolver {


    @Override
    public String doSolve() {
        long[] result = LongStream.rangeClosed(1000, 10000000)
                .parallel()
                .map(x -> x * x)
                .filter(y -> hasThreeSameLastDigits(y))
                .toArray();
        return Arrays.toString(result);
    }

    protected boolean hasThreeSameLastDigits(Long y) {
        long[] digits = NumberStringConversions.longToLongArray(y);
        if (LongStream.of(digits).anyMatch(x -> x == 0)) {
            return false;
        }
        int length = digits.length;
        return (digits[length - 1] == digits[length - 2]) && (digits[length - 2] == digits[length - 3]);
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new MathProblems100());
    }
}
