package com.yambacode.solutions.euler16

import com.yambacode.solutions.AbstractEulerSolver
import com.yambacode.solutions.EulerRunner
import groovy.transform.TailRecursive

/**
 * Created by cbyamba on 2014-11-24.
 */
class GroovyEuler16 extends AbstractEulerSolver {

    @Override
    String doSolve() {
        return reduce()
    }

    @TailRecursive
    def reduce(BigInteger n = 2**1000, BigInteger sum = 0) {
        if (n <= 0) {
            return sum
        }
        return reduce(n.divide(10), sum.add(n.mod(10)))
    }

    public static void main(args) {
        EulerRunner.runEulerSolvers(new GroovyEuler16())
    }
}
