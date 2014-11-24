package com.yambacode.solutions.euler16;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import static com.yambacode.common.util.CollectionConversion.bigIntegerToDigits;
import static java.math.BigInteger.valueOf;
import static java.util.stream.IntStream.of;

/**
 * Created by cbyamba on 2014-01-14.
 */
public class PowerDigitSum extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        return "" + of(bigIntegerToDigits(valueOf(2)
                .pow(1000)))
                .sum();
    }

    public static void main(String[] args) {
        EulerRunner.runEulerSolvers(new PowerDigitSum());
    }
}
