package com.seewhy.solutions.euler97;

import com.seewhy.solutions.AbstractEulerSolver;
import com.seewhy.solutions.EulerRunner;

import static com.seewhy.solutions.euler97.BigIntegers._;

/**
 * Created by cbyamba on 2014-08-23.
 */
public class LargeNonMersennePrime extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        return _(28433).multiply(_(2)).add(_(1)).mod(_(10_000_000_000l)).toString();
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new LargeNonMersennePrime());
    }
}
