package com.yambacode.solutions.euler2;


import static com.yambacode.math.FigurativeNumbers.*;

import com.yambacode.common.io.Printer;
import com.yambacode.solutions.AbstractEulerSolver;

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
        Printer.print(new EvenFibonacciNumbers().solve());
    }
}
