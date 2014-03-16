package com.seewhy.solutions.euler1;

import com.seewhy.common.io.Printer;
import com.seewhy.solutions.AbstractEulerSolver;

import java.util.stream.LongStream;

/**
 * Created by cbyamba on 2014-01-07.
 */
public class MultiplesOf3And5 extends AbstractEulerSolver {

    public static final int SIZE = 1000000;

    @Override
    public String doSolve() {
        return "" + LongStream.range(1, SIZE).filter(x -> x % 3 == 0 || x % 5 == 0).sum();
    }

    public static void main(String... args) {
        Printer.print(new MultiplesOf3And5().solve().toString());
    }
}
