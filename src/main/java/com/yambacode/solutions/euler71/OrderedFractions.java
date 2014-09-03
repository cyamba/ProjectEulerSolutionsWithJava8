package com.yambacode.solutions.euler71;

import com.yambacode.common.io.Printer;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.util.stream.LongStream;

/**
 * Created by cbyamba on 2014-09-03.
 */
public class OrderedFractions extends AbstractEulerSolver {

    //private static long MAX = 1_000_000;
    private static long MAX = 1_00;


    @Override
    public String doSolve() {
        return LongStream.rangeClosed(1, MAX)
                .boxed()
                .parallel()
                .flatMap(d -> LongStream.range(1, d)
                        .mapToObj(n -> Fraction.of(n, d)))
                .peek(f -> Printer.print(f.toString()))
                .sorted((f1, f2) -> f2.compareTo(f1))//reversed order
                .filter(f -> f.compareTo(Fraction.of(3, 7)) < 1)
                .findFirst()
                .get()
                .toString();
    }


    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new OrderedFractions());
    }
}
