package com.seewhy.solutions.euler1;

import com.seewhy.common.io.Printer;
import com.seewhy.solutions.AbstractEulerSolver;

/**
 * Created by cbyamba on 2014-02-10.
 */
public class ImperativeSolution extends AbstractEulerSolver {


    @Override
    public String doSolve() {
        long sum = 0;
        for (long i = 1; i < MultiplesOf3And5.SIZE; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return "" + sum;
    }

    public static void main(String... args) {
        Printer.print(new ImperativeSolution().solve());
    }
}
