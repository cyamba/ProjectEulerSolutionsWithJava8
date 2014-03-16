package com.seewhy.solutions.euler20;

import com.seewhy.solutions.AbstractEulerSolver;

import static com.seewhy.common.util.CollectionConversion.bigIntegerToDigits;
import static com.seewhy.math.Combinatorics.faculty;
import static java.util.stream.IntStream.of;

/**
 * Created by cbyamba on 2014-01-14.
 */
public class FactorialDigitSum extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        return "" + of(bigIntegerToDigits(faculty(100)))
                .sum();
    }
}
