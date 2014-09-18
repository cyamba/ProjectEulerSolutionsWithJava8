package com.yambacode.solutions.euler31;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

/**
 * Created by cbyamba on 2011-12-03
 */
public class GeneratingFunctionCoeffOneLoopSlow extends AbstractEulerSolver {
    @Override
    public String doSolve() {
        return compute().toString();
    }

    public Number compute() {
        int coefficient = 0;

        int nbrOfFactors = 8;
        int power = 200;
        for (long i = 0; i <= Math.pow(power, nbrOfFactors); i++) {
            int j = nbrOfFactors;
            int sum = (int) (i / Math.pow(power, --j))
                    + (int) (2 * i / Math.pow(power, --j) % power)
                    + (int) (5 * i / Math.pow(power, --j) % power)
                    + (int) (10 * i / Math.pow(power, --j) % power)
                    + (int) (20 * i / Math.pow(power, --j) % power)
                    + (int) (50 * i / Math.pow(power, --j) % power)
                    + (int) (100 * i / Math.pow(power, --j) % power)
                    + (int) (200 * i % power);
            coefficient += (sum == power) ? 1 : 0;

        }
        return coefficient;
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new GeneratingFunctionCoeffOneLoopSlow());
    }

}
