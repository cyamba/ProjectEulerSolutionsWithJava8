package com.yambacode.solutions.euler47;

import com.yambacode.math.Divisibility;
import com.yambacode.math.Primes;
import com.yambacode.math.Result;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.util.List;

/**
 * Created by cbyamba on 2011
 */
public class DistinctNumberOfPrimeFactorizations extends AbstractEulerSolver {

    private static final int COUNT = 4;

    public Number compute() {
        Result result = null;
        List<Long> primes = Primes.generatePrimesAsList(1000000);
        int i = 4;
        while (i < 1000000) {
            int count = 0;
            while ((result = Divisibility.numberOfPrimeFactors(i, primes))
                    .getCount() == COUNT) {
                count++;
                i++;
            }
            if (count == COUNT) {
                return i - (COUNT);
            }
            i++;
        }
        return --i;
    }

    @Override
    public String doSolve() {
        return compute().toString();
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException("fixemeifyoucan!");
    }
}
