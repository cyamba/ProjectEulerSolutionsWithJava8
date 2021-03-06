package com.yambacode.solutions.euler20;

import com.yambacode.solutions.AbstractEulerSolver;

import static com.yambacode.common.util.CollectionConversion.bigIntegerToDigits;
import static com.yambacode.math.combinatorics.Combinatorics.factorial;
import static java.util.stream.IntStream.of;

/**
 * Created by cbyamba on 2014-01-14.
 */
public class FactorialDigitSum extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        return "" + of(bigIntegerToDigits(factorial(100)))
                .sum();
    }
}
