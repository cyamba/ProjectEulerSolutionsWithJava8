package com.yambacode.solutions.euler2;


import static com.yambacode.math.FigurativeNumbers.*;

import com.yambacode.common.io.Printer;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.util.stream.LongStream;

/**
 * Created by cbyamba on 2014-01-08.
 */
public class EvenFibonacciNumbers extends AbstractEulerSolver {


    public static final long MAX = 4000000l;

    @Override
    public String doSolve() {
        return "" + LongStream.of(fibbo(MAX, new long[]{1, 1})).filter(x -> x % 2 == 0).sum();
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(
                new EvenFibonacciNumbers()
                //,
               // new Euler2Imperative(),
               // new GroovyEuler2(),
               // new EvenFibonacciNumbers(),
               // new GroovyEuler2(),
               // new Euler2Imperative()
        );
    }
}
