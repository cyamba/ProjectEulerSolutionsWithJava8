package com.yambacode.solutions.euler26;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbyamba on 2014-09-18.
 */
public class SimpleRecurringCycles extends AbstractEulerSolver {
    @Override
    public String doSolve() {
        return calculate().toString();
    }

    public Number calculate() {
        int maxValue = 0;
        int max = 0;
        for (int divisor = 2; divisor < 1000; divisor++) {
            List<Integer> decimals = new ArrayList<Integer>();
            int remainder = 10;
            int count = 0;
            while (!decimals.contains(remainder)) {
                decimals.add(remainder);
                remainder = 10 * (remainder % divisor);
                count++;
            }
            if (count > maxValue) {
                maxValue = count;
                max = divisor;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        EulerRunner.runEulerSolvers(new SimpleRecurringCycles());
    }
}
