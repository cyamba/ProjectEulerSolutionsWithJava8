package com.seewhy.experiments;

import com.seewhy.common.io.Printer;

import static com.seewhy.common.util.NumberStringConversions.longToLongArray;
import static com.seewhy.common.util.UpDownCastArrays.upCast;

import com.seewhy.solutions.AbstractEulerSolver;
import com.seewhy.solutions.EulerRunner;

import static java.util.Arrays.deepEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.LongStream;

/**
 * Created by cbyamba on 2014-03-08.
 */
public class MathProblem86 extends AbstractEulerSolver {
    @Override
    public String doSolve() {
        long[] result = LongStream.rangeClosed(4, 1000000).map(x -> x * x).filter(this::isAscending).toArray();
        return Arrays.toString(result);
    }

    public boolean isAscending(Long number) {
        long[] digits = longToLongArray(number);
        long[] sortedDigits = LongStream.of(digits).sorted().toArray();
        return deepEquals(upCast(digits), upCast(sortedDigits));

    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new MathProblem86());
    }
}
