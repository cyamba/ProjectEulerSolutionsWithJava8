package com.seewhy.experiments;

import com.seewhy.common.util.NumberStringConversions;
import com.seewhy.solutions.AbstractEulerSolver;
import com.seewhy.solutions.EulerRunner;

import java.util.Arrays;
import java.util.stream.LongStream;

/**
 * Created by cbyamba on 2014-03-08.
 */
public class MathProblem87 extends AbstractEulerSolver {
    @Override
    public String doSolve() {
        long[] result = LongStream.rangeClosed(1, 100000)
                .parallel()
                .map(x -> x * x).filter(this::hasDistinctDigits).toArray();
        return Arrays.toString(result);
    }

    public boolean hasDistinctDigits(Long number) {
        long[] digits = NumberStringConversions.longToLongArray(number);
        return LongStream.of(digits).distinct().count() == number.toString().length();
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new MathProblem87());
    }
}
