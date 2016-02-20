package com.yambacode.solutions.euler97;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import static com.yambacode.solutions.euler97.BigIntegers.__;

/**
 * Created by cbyamba on 2014-08-23.
 */
public class LargeNonMersennePrime extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        return __(28433).multiply(__(2)).add(__(1)).mod(__(10_000_000_000l)).toString();
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new LargeNonMersennePrime());
    }
}
