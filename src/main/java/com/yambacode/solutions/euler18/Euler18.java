package com.yambacode.solutions.euler18;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

/**
 * Created by cbyamba on 2014-09-18.
 */
public class Euler18 extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        return compute().toString();
    }

    public Number compute() {
        int[][] foodForGreed = TriangleFactory.getFoodForGreed();
        for (int i = foodForGreed.length - 2; i >= 0; i--)
            for (int j = 0; j <= i; j++)
                foodForGreed[i][j] += Math.max(foodForGreed[i + 1][j], foodForGreed[i + 1][j + 1]);
        return foodForGreed[0][0];
    }

    public static void main(String[] args) {
        EulerRunner.runEulerSolvers(new Euler18());
    }
}
