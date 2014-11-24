package com.yambacode.solutions.euler20

import com.yambacode.solutions.AbstractEulerSolver
import com.yambacode.solutions.EulerRunner
import groovy.transform.TailRecursive

/**
 * Created by cbyamba on 2014-11-24.
 */
class GroovyEuler20 extends AbstractEulerSolver {


    @Override
    String doSolve() {
        reduce(factorial())
    }

    @TailRecursive
    def factorial(BigInteger n = 100, BigInteger prod = 1) {
        if (n <= 1) {
            return prod
        }
        factorial(--n, n * prod)
    }

    @TailRecursive
    def reduce(BigInteger n, BigInteger sum = 0) {
        if (n <= 0) {
            return sum
        }
        reduce(n.divide(10), sum.add(n.mod(10)))
    }

    public static void main(args) {
        EulerRunner.runEulerSolvers(new GroovyEuler20())
    }
}
