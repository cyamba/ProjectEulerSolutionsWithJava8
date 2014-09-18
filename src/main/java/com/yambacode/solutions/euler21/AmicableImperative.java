package com.yambacode.solutions.euler21;

import com.yambacode.math.Sums;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cbyamba on 2011
 */
public class AmicableImperative extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        return compute().toString();
    }

    public Number compute() {
        int sum = 0;
        Set<Integer> amicables = new HashSet<Integer>();
        for (int i = 1; i < 10000; i++) {
            if (amicables.contains(i)) {
                continue;
            }
            Integer amicable = Sums.sumOfProperDivisors(i);
            if (Sums.sumOfProperDivisors(amicable) == i) {
                if (i == amicable)
                    continue;
                amicables.add(i);
                amicables.add(amicable);
                sum += i + amicable;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        EulerRunner.runEulerSolvers(new AmicableImperative());
    }
}
