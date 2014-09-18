package com.yambacode.solutions.euler24;

import com.yambacode.math.Combinatorics;
import com.yambacode.solutions.AbstractEulerSolver;

/**
 * Created by cbyamba on 2011-11-26
 * This is more or less a algorithm based on Dijkstras Lexicographical Permutation Algorithm.
 */
public class DijkstrasPermutationAlgorithmImpl extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        return compute().toString();
    }

    private static final int SIZE = 10;
    private static final int MAX = Combinatorics.factorial(SIZE).intValue();
    private int[] permutation = new int[SIZE];
    private static int count = 0;
    private static int POSITION = 1000000;

    public Number compute() {
        init();
        while (true) {
            if (count >= MAX) {
                break;
            }
            if (count >= POSITION) {
                break;
            }
            permutation = nextPermutation();
        }
        return asNumber(permutation);
    }

    private Long asNumber(int... perm) {
        Long number = null;
        StringBuilder builder = new StringBuilder();
        for (int i : perm) {
            builder.append(i);
        }
        return number = Long.valueOf(builder.toString());
    }

    private int[] nextPermutation() {
        if (count == 0) {
            return permutation;
        }
        int j = findMaximumIndexOfConsecutiveDescent();
        int k = findMinimumScatteredDescentOfJ(j);
        swap(j, k);
        orderTailIncreasinglyAfterJ(j);
        count++;
        return permutation;
    }

    private void orderTailIncreasinglyAfterJ(int j) {
        int begin = j + 1;
        int end = permutation.length - 1;
        int temp = -1;
        while (end > begin) {
            temp = permutation[begin];
            permutation[begin++] = permutation[end];
            permutation[end--] = temp;
        }
    }

    private void swap(int j, int k) {
        int temp = permutation[k];
        permutation[k] = permutation[j];
        permutation[j] = temp;
    }

    /**
     * You are looking for the minimal scattered subword 12 (scattered descent) in the permutation
     * starting from position j in the permutation.
     *
     * @param j
     * @return
     */
    private int findMinimumScatteredDescentOfJ(int j) {
        int i = permutation.length - 1;
        while (permutation[j] > permutation[i]) {
            i--;
            //j is looking for the next closest challenge.
        }
        return i;
    }


    /**
     * Aiming high he did. But when no one challenged his level he decremented to a lesser peer.
     *
     * @return
     */
    private int findMaximumIndexOfConsecutiveDescent() {
        int j = permutation.length - 2;
        //as long as you are an ascent continue until you are not (and thus an ascent since S_n)
        while (permutation[j] > permutation[j + 1]) {
            j--;
        }
        return j;
    }


    private void init() {
        for (int i = 0; i < SIZE; i++) {
            permutation[i] = i;
        }
        count++;
    }

    private void print(int... permutation) {
        System.out.println();
        for (int i : permutation) {
            System.out.print(i);
        }
        System.out.println();
    }

}
