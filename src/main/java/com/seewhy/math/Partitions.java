package com.seewhy.math;

/**
 * Created by cbyamba on 2014-01-13.
 */
public class Partitions {

    public static int[][] toEqualParts(Integer[] objects, int n) {
        if (objects.length % n != 0) {
            return new int[0][0];
        }
        int[][] partition = new int[objects.length / n][n];
        for (int i = 0; i < objects.length; i++) {
            partition[i / n][i % n] = objects[i];
        }
        return partition;
    }


}
