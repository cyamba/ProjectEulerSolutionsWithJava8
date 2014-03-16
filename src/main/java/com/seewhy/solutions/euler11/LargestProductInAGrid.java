package com.seewhy.solutions.euler11;

import com.seewhy.solutions.AbstractEulerSolver;

import java.io.File;

/**
 * Created by cbyamba on 2014-01-14.
 */
public class LargestProductInAGrid extends AbstractEulerSolver {

    private static final String PATH = "/Users/cbyamba/IdeaProjects/Java8Poc/src/com/company/euler/euler11/grid.eu";

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
}
