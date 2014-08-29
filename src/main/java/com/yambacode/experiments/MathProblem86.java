package com.yambacode.experiments;

import static com.yambacode.common.util.NumberStringConversions.longToLongArray;
import static com.yambacode.common.util.UpDownCastArrays.upCast;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import static java.util.Arrays.deepEquals;

import java.util.Arrays;
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
