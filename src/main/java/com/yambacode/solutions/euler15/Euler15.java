package com.yambacode.solutions.euler15;

import com.yambacode.solutions.AbstractEulerSolver;

import static com.yambacode.math.Combinatorics.combinations;

/**
 * Created by cbyamba on 2014-01-14.
 */
public class Euler15 extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        return combinations(40, 20).toString();
    }
}
