package com.yambacode.solutions.euler12;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

/**
 * Created by cbyamba
 * 2011-10-25
 */
public class TriangleNumberDivisorImperative extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        long number = 0;
        long j = 0;
        while (true) {
            number += ++j;
            int count = 0;
            for (int i = 1; i < Math.sqrt(number); i++) {
                if (number % i == 0) {
                    count += 2;
                }
            }
            if (count > 500) {
                break;
            }
        }
        return "" + number;
    }

    public static void main(String[] args) {
        EulerRunner.runEulerSolvers(new TriangleNumberDivisorImperative());
    }
}
