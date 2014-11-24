package com.yambacode.solutions.euler2

import com.yambacode.solutions.AbstractEulerSolver
import com.yambacode.solutions.EulerRunner

/**
 * Created by christopher.yamba on 24/11/14.
 */
class GroovyEuler2 extends AbstractEulerSolver{

    @Override
    String doSolve() {
        return GroovyFibbo.fibbo(4_000_000)
    }

    public static void main(args) {
       EulerRunner.runEulerSolvers(new GroovyEuler2())
    }
}
