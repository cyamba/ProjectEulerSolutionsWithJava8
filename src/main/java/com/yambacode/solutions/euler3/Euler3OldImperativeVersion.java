package com.yambacode.solutions.euler3;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.math.BigInteger;

/**
 * Created by cbyamba on 2011-11-10
 */
public class Euler3OldImperativeVersion extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        BigInteger number = new BigInteger("600851475143");
        BigInteger divisor = BigInteger.valueOf((long) 3);
        while (true) {
            while (number.mod(divisor).equals(BigInteger.ZERO)) {
                number = number.divide(divisor);
            }
            if (number.compareTo(BigInteger.ONE) <= 0)
                break;
            divisor = divisor.add(BigInteger.valueOf((long) 2));
        }
        return divisor.toString();
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new Euler3OldImperativeVersion());
    }
}
