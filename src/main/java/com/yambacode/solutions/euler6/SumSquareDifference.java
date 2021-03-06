package com.yambacode.solutions.euler6;


import com.yambacode.solutions.AbstractEulerSolver;

import static com.yambacode.math.YMath.squareOfArithmeticSum;
import static com.yambacode.math.YMath.sumOfSquares;

/**
 * Created by cbyamba on 2014-01-13.
 */
public class SumSquareDifference extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        return "" + (squareOfArithmeticSum(100) - sumOfSquares(100));
    }
}
