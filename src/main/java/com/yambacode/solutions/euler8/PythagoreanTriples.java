package com.yambacode.solutions.euler8;

import java.util.Arrays;

/**
 * Created by cbyamba on 2014-09-18.
 */
public class PythagoreanTriples {

    public static boolean isPythagoreanTriple(int... triple) {
        if (triple.length != 3) {
            return false;
        }
        Arrays.sort(triple);
        if (triple[0] == triple[1] || triple[1] == triple[2]) {
            return false;
        }
        if (Math.pow(triple[0], 2) + Math.pow(triple[1], 2) != Math.pow(triple[2], 2)) {
            return false;
        }
        return true;
    }

    public static int getA(int k, int m, int n) {
        return k * (m * m - n * n);
    }

    public static int getB(int k, int m, int n) {
        return 2 * k * m * n;
    }

    public static int getC(int k, int m, int n) {
        return k * (m * m + n * n);
    }

    public static int[] getABC(int k, int m, int n) {
        return new int[]{k * (m * m - n * n), 2 * k * m * n, k * (m * m + n * n)};
    }
}
