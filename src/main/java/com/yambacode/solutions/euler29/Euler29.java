package com.yambacode.solutions.euler29;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;
import com.yambacode.solutions.euler18.Euler18;

import java.math.BigInteger;
import java.util.HashSet;

/**
 * Created by cbyamba on 2011-12-01
 */
public class Euler29 extends AbstractEulerSolver {
    @Override
    public String doSolve() {
        return bruteForce().toString();
    }

    private Integer bruteForce() {
        HashSet<BigInteger> allPowers = new HashSet<BigInteger>();
        for (long i = 2; i <= 100; i++) {
            for (int j = 2; j <= 100; j++) {
                allPowers.add(BigInteger.valueOf(i).pow(j));
            }
        }
        return allPowers.size();
    }

    public static void main(String[] args) {
        EulerRunner.runEulerSolvers(new Euler29());
    }
}
