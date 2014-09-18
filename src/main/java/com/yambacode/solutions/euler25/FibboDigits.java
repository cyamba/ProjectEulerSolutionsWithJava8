package com.yambacode.solutions.euler25;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.math.BigInteger;

/**
 * Created by cbyamba on 2011-11-26
 */
public class FibboDigits extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        return compute().toString();
    }

    public Number compute() {
        BigInteger first = BigInteger.ONE;
        BigInteger second = BigInteger.ONE;
        BigInteger number = second;
        Long count = 2L;
        while (true) {
            count++;
            number = first.add(second);
            first = second;
            second = number;
            if (number.toString().length() == 1000) {
                return count;
            }
        }
    }

    public static void main(String[] args) {
        EulerRunner.runEulerSolvers(new FibboDigits());
    }
}
