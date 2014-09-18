package com.yambacode.solutions.euler32;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbyamba on  2011-12-04
 */
public class PandigitalNumbers extends AbstractEulerSolver {


    public Number compute() {
        BigInteger sum = BigInteger.ZERO;
        outer:
        for (long i = 1; i < 98765; i++) {
            inner:
            for (long j = 1; j < i; j++) {
                if (i % j == 0) {
                    if (isPandigital(i, i / j, j)) {
                        System.out.println(i + " = " + (i / j) + " * " + j);
                        sum = sum.add(BigInteger.valueOf(i));
                        continue outer;
                    }
                }
            }
        }
        return sum;
    }

    public boolean isPandigital(Long... numbers) {
        String numberStr = "";
        for (Long n : numbers) {
            numberStr = numberStr.concat(n.toString());
        }
        if (numberStr.length() != 9)
            return false;
        return isPandigital(Long.valueOf(numberStr));
    }

    private boolean isPandigital(Long number) {
        List<Character> chars = new ArrayList<Character>();
        char zero = '0';
        for (char c : number.toString().toCharArray()) {
            if (chars.contains(c)) {
                return false;
            }
            if (c == zero) {
                return false;
            }
            chars.add(c);
        }
        return true;
    }

    @Override
    public String doSolve() {
        return compute().toString();
    }

    public static void main(String... args) {
        //TODO optimize
        EulerRunner.runEulerSolvers(new PandigitalNumbers());
    }
}
