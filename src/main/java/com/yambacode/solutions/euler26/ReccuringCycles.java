package com.yambacode.solutions.euler26;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.math.BigInteger;

/**
 * Created by cbyamba on 2011-11-28
 */
public class ReccuringCycles extends AbstractEulerSolver {

    public Number calculate() {
        BigInteger number = BigInteger.valueOf(999);
        int max = 0;
        while (number.intValue() > 0) {
            while (!number.isProbablePrime(10)) {
                number = number.subtract(BigInteger.valueOf(2L));
            }
            if (((int) Math.pow(10, number.intValue() - 1)) % number.intValue() == 1) {
                return number;
            }
            number = number.subtract(BigInteger.valueOf(2L));
            if (number.compareTo(BigInteger.ZERO) < 0) {
                return -1;
            }
        }
        return max;
    }

    @Override
    public String doSolve() {
        return calculate().toString();
    }

    public static void main(String[] args) {
        EulerRunner.runEulerSolvers(new ReccuringCycles());
    }
}
