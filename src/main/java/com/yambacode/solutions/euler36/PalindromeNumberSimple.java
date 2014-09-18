package com.yambacode.solutions.euler36;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

/**
 * Created by cbyamba on 2014-09-18.
 */
public class PalindromeNumberSimple extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        return compute().toString();
    }

    public Number compute() {
        long sum = 0;
        for (int i = 1; i < 1000000; i += 2) {
            sum += (isPalindromeInvariant(i)) ? i : 0;
        }
        return sum;
    }

    public boolean isPalindromeInvariant(Integer i) {
        String number = i.toString();
        String numberBinary = Integer.toBinaryString(i);
        return number.equals(new StringBuilder().append(number).reverse().toString()) &&
                numberBinary.equals(new StringBuilder().append(numberBinary).reverse().toString());

    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new PalindromeNumberSimple());
    }
}
