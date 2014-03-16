package com.seewhy.solutions.euler6;


import com.seewhy.solutions.AbstractEulerSolver;

import static com.seewhy.math.MathGeneral.squareOfArithmeticSum;
import static com.seewhy.math.MathGeneral.sumOfSquares;

/**
 * Created by cbyamba on 2014-01-13.
 */
public class SumSquareDifference extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        return "" + (squareOfArithmeticSum(100) - sumOfSquares(100));
    }
}
