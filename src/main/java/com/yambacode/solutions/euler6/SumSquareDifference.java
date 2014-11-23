package com.yambacode.solutions.euler6;


import com.yambacode.math.Sums;
import com.yambacode.solutions.AbstractEulerSolver;



/**
 * Created by cbyamba on 2014-01-13.
 */
public class SumSquareDifference extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        return "" + (Sums.getSquareOfSums(100) - Sums.getSumOfSquares(100));
    }
}
