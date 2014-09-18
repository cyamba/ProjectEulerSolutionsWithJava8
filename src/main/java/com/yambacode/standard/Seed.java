package com.yambacode.standard;

import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-09-17.
 */
public class Seed {

    public static int[] randomIntegers(int length) {
        return IntStream.range(0, length).map(x -> (int) (Math.random() * length)).toArray();
    }

}
