package com.seewhy.solutions.euler98;

import com.seewhy.math.Permutations;

/**
 * Created by cbyamba on 2014-04-02.
 */
public class Anagramer {

    public static Comparable[] reArrangeWith(Comparable[] original, Integer[] indices) {
        return Permutations.multiply(original, indices);
    }
}
