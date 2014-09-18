package com.yambacode.solutions.euler11;

/**
 * Created by cbyamba on 2011-11-14
 */
public class MatrixUtil {


    public static Integer checkMatrix(int[][] arr) {

        int currentMax = 1;
        int temp = 1;

        //check rows
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {
                temp *= arr[i][j];
            }
            if (temp > currentMax) {
                currentMax = temp;
            }
            temp = 1;
        }

        //check columns
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {
                temp *= arr[j][i];
            }
            if (temp > currentMax) {
                currentMax = temp;
            }
            temp = 1;
        }

        //check  diagonals
        for (int i = 0; i < arr.length; i++) {
            temp *= arr[i][i];

        }
        if (temp > currentMax) {
            currentMax = temp;
        }
        temp = 1;

        for (int i = 0; i < arr.length; i++) {

            temp *= arr[i][arr.length - 1 + (-1 * i)];


        }
        if (temp > currentMax) {
            currentMax = temp;
        }
        temp = 1;

        return currentMax;
    }

}
