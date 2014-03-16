package com.seewhy.solutions.euler61;

import static com.seewhy.math.Numbers.*;
import com.seewhy.solutions.AbstractEulerSolver;
import com.seewhy.solutions.EulerRunner;

import java.util.Arrays;

/**
 * Created by cbyamba on 2014-02-10.
 */
public class CyclicalFigurateNumbers extends AbstractEulerSolver {

    public static final int START = 1000;
    public static final int END = 9999;


    @Override
    public String doSolve() {
        Object[] objects = triangularNumbersLessThan(START, END).stream().filter(x -> isSquareNumber(x)).toArray();
        return Arrays.toString(objects);
    }


    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new CyclicalFigurateNumbers());
    }
}
