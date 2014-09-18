package com.yambacode.solutions.euler16;

import com.yambacode.solutions.AbstractEulerSolver;

import static com.yambacode.solutions.euler97.BigIntegers._2;

/**
 * Created by cbyamba on 2011-11-20
 */
public class SumOfDigitsImperative extends AbstractEulerSolver {
    @Override
    public String doSolve() {
        Integer sum = 0;
        String numberStr = _2.pow(1000).toString();
        for (int i = 0; i < numberStr.length(); i++) {
            sum += Integer.parseInt(String.valueOf(numberStr.charAt(i)));
        }
        return sum.toString();
    }

}
