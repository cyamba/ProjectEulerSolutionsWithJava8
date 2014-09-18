package com.yambacode.solutions.euler23;

import com.yambacode.math.Sums;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by cbyamba on 2014-11-27
 */
public class AbundantNumbers extends AbstractEulerSolver {
    //28123
    private static final int SIZE = 28123;
    private HashSet<Integer> abundants = new HashSet<Integer>();
    private HashSet<Integer> abundantSums = new HashSet<Integer>();

    public Number calculate() {
        Integer sumOfAllIntegers = Sums.arithmeticSum(SIZE);
        Integer sum = 0;
        for (int i = 1; i < SIZE; i++) {
            if (Sums.sumOfProperDivisors(i) > i) {
                abundants.add(i);
            }

        }
        computeAbundantSums(abundants);
        for (int i = 1; i < SIZE; i++) {
            if (!isAbundandLinearCombinationOfSizeTwo(i)) {
                sum += i;
            }
        }
        return sum;
    }

    private void computeAbundantSums(HashSet<Integer> abundants) {
        Iterator<Integer> abnIterator = abundants.iterator();
        while (abnIterator.hasNext()) {
            Integer current = abnIterator.next();
            for (Integer abundant : abundants) {
                int linearComb = current + abundant;
                if (linearComb > SIZE) {
                    break;
                }
                abundantSums.add(linearComb);
            }
        }
    }

    private boolean isAbundandLinearCombinationOfSizeTwo(int number) {
        return abundantSums.contains(number);
    }

    @Override
    public String doSolve() {
        return calculate().toString();
    }

    public static void main(String[] args) {
        EulerRunner.runEulerSolvers(new AbundantNumbers());
    }
}
