package com.seewhy.solutions.euler100;

import com.seewhy.common.io.Printer;
import com.seewhy.solutions.AbstractEulerSolver;
import com.seewhy.solutions.EulerRunner;
import com.seewhy.solutions.euler54.poker.Tuple;

import java.math.BigInteger;

/**
 * Created by cbyamba on 2014-07-24.
 */
public class ArrangedProbability extends AbstractEulerSolver {

    public static final long TOTAL = 1000_000l;


    //TODO binary search kind of algorithm
    @Override
    public String doSolve() {
        long first = (long) Math.sqrt(TOTAL) / 2;
        long total = TOTAL;
        while (foo(first, total) == -1) {
            total++;
            first = (long) Math.sqrt(total) / 2;
            Printer.print("total = " + total + " first = " + first);
        }
        return "" + first;
    }

    public long foo(long first, long total) {
        long numerator = first;
        long denominator = total;
        BigFraction product = BigFraction.of(numerator, denominator).multiply(BigFraction.of(numerator - 1, denominator - 1));
        while (product.compareToOneHalf() < 0) {
            numerator++;
            product = BigFraction.of(numerator, denominator).multiply(BigFraction.of(numerator - 1, denominator - 1));
            //Printer.print(numerator + " " + product.compareToOneHalf() + " " + product.value());
        }
        if (product.compareToOneHalf() == 0) {
            return first;
        }
        return -1;
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new ArrangedProbability());
    }


}
