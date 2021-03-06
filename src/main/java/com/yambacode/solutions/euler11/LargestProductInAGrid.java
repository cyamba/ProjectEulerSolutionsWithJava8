package com.yambacode.solutions.euler11;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.io.File;

/**
 * Created by cbyamba on 2014-01-14.
 */
public class LargestProductInAGrid extends AbstractEulerSolver {

    private static final String PATH = "./src/main/java/com/yambacode/solutions/euler11/grid.eu";

    @Override
    public String doSolve() {
        int[][] grid = ContentReaderEuler11.getGridContent(new File(PATH));
        printArr(grid);
        return null;
    }

    private static void printArr(int[][] arr) {
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String...args) {
        EulerRunner.runEulerSolvers(new LargestProductInAGrid());
    }
}
