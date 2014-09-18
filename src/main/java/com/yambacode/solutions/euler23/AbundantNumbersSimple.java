package com.yambacode.solutions.euler23;

import com.yambacode.math.Sums;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

/**
 * Created by cbyamba on 2014-09-18.
 */
public class AbundantNumbersSimple extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        return calculate().toString();
    }

    private static final int SIZE = 28123;

    /**
     * @return
     */
    public Number calculate() {
        int[] abundant = createAbundants();

        boolean[] isAbundant = createIsAbundants(abundant);

        return getSumOfNonAbundants(isAbundant);
    }

    private Number getSumOfNonAbundants(boolean[] abundant) {
        int sum = 0;
        for (int i = 0; i <= SIZE; i++) {
            if (!abundant[i])
                sum += i;
        }

        return sum;
    }

    private boolean[] createIsAbundants(int[] abundant) {
        boolean isAbundant[] = new boolean[SIZE];
        for (int i = 0; abundant[i] != 0; i++) {
            for (int j = 0; abundant[j] != 0; j++) {
                if (abundant[i] + abundant[j] <= SIZE) {
                    isAbundant[abundant[i] + abundant[j]] = true;
                }
            }
        }
        return isAbundant;
    }

    private int[] createAbundants() {
        int abundant[] = new int[20000];
        int index = 0;
        for (int i = 2; i < SIZE; i++) {
            if (Sums.sumOfProperDivisors(i) > i) {
                abundant[index++] = i;
            }
        }
        return abundant;
    }

    public static void main(String[] args) throws Exception {
        //EulerRunner.runEulerSolvers(new AbundantNumbersSimple());
        //TODO fixeme!
        throw new UnsupportedOperationException("Fixme I'm broken! :) ");
    }
}
