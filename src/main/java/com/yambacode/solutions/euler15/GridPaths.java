package com.yambacode.solutions.euler15;

import com.yambacode.solutions.AbstractEulerSolver;

import static com.yambacode.math.combinatorics.Combinatorics.combinations;

/**
 * * A nice little case of multinomial coefficient.
 * <p>
 * In general - going through all paths from corner (0,0,...,0) to "diagonal corner" (x1,x2,...,xn) in a k-dimensional
 * hyper rectangle would transalate into a solution where you get the multinomial coefficient:
 * (x1+x2+x3+...+xn)!/(x1!x2!x3!*...*xn!)
 *
 * Created by cbyamba on  * 2011-11-20
 */
public class GridPaths extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        return combinations(40, 20).toString();
    }
}
