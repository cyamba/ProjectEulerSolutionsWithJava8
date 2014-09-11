package com.yambacode.experiments;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.util.Arrays;
import java.util.stream.LongStream;

import static com.yambacode.math.FigurativeNumbers.fibbo;

/**
 * Created by cbyamba on 2014-03-08.
 */
public class MathProblem89 extends AbstractEulerSolver {

    private static final long MAX = 100000000000000l;

    //TODO modulo m and find period
    @Override
    public String doSolve() {
        long[] fibbos = LongStream.of(fibbo(MAX, new long[]{1, 1})).map(x -> x % 10).toArray();
        return Arrays.toString(fibbos)+" "+fibbos.length;
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new MathProblem89());
    }
}
