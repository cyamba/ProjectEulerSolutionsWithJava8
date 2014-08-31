package com.yambacode.experiments.bracelet;


import static java.util.Comparator.reverseOrder;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.yambacode.experiments.bracelet.Pearls.flattenedEquals;

/**
 * Created by cbyamba on 2014-08-29.
 */
public class Bracelet {

    private String[] pearls;

    private Bracelet(String[] pearls) {
        this.pearls = pearls;
    }

    public static Bracelet of(String... pearls) {
        return new Bracelet(pearls);
    }

    public String[] getPearls() {
        return pearls;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        String[] otherPearls = ((Bracelet) other).getPearls();
        if (otherPearls == null) {
            return false;
        }
        return flattenedEquals(pearls, otherPearls);
        //could have kept the rotation equals as before and just invoked flattenedEquals with :
//        int length = pearls.length;
//        String[] pearlsReversed = IntStream.range(0, length)
//                .mapToObj(i -> pearls[length - 1 - i])
//                .toArray(x -> new String[length]);
//        return flattenedEquals(pearls, otherPearls) || flattenedEquals(pearlsReversed, otherPearls);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(pearls);
    }

}
