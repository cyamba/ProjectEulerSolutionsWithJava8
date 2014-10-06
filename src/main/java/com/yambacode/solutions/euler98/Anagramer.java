package com.yambacode.solutions.euler98;

import com.yambacode.math.combinatorics.Permutations;

/**
 * Created by cbyamba on 2014-04-02.
 */
public class Anagramer {

    public static Comparable[] reArrangeWith(Comparable[] original, Integer[] indices) {
        return Permutations.multiply(original, indices);
    }
}
