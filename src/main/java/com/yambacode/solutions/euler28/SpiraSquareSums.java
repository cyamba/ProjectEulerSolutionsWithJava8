package com.yambacode.solutions.euler28;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

/**
 * Created by cbyamba on 2011-12-01
 */
public class SpiraSquareSums extends AbstractEulerSolver {

    public Number calculate() {
        long sum = 1;
        for (long n = 3; n <= 1001; n += 2) {
            sum += getSum(n);
        }
        return sum;
    }

    private long getSum(long n) {
        return 2 * (n * n + ((n - 2) * (n - 2) + (n - 1)));
    }

    @Override
    public String doSolve() {
        return calculate().toString();
    }

    public static void main(String[] args) {
        EulerRunner.runEulerSolvers(new SpiraSquareSums());
    }
}
