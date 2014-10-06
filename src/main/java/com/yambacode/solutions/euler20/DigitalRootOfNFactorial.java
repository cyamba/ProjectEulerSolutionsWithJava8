package com.yambacode.solutions.euler20;

import com.yambacode.math.combinatorics.Combinatorics;
import com.yambacode.solutions.AbstractEulerSolver;

import java.math.BigInteger;

/**
 * Created by cbyamba on 2011-11-24
 */
public class DigitalRootOfNFactorial extends AbstractEulerSolver {


    public Number calculate() {
        BigInteger number = Combinatorics.factorial(100);
        Integer sum = 0;
        String numberStr = number.toString();
        for (int i = 0; i < numberStr.length(); i++) {
            sum += Integer.parseInt(String.valueOf(numberStr.charAt(i)));
        }
        return sum;
    }

    @Override
    public String doSolve() {
        return calculate().toString();
    }
}
