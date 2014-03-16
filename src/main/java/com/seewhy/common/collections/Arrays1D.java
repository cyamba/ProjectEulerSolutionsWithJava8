package com.seewhy.common.collections;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-03-13.
 */
public class Arrays1D {

    public static boolean deepEquals(int[] first, int[] second) {
        if (first.length != second.length) {
            return false;
        }
        return IntStream.range(0, first.length).allMatch(i -> first[i] == second[i]);
    }

    //TODO move to Characters?
    public static Character[] intToCharArray(int[] intArr) {
        Integer[] integers = IntStream.of(intArr).boxed().toArray(x -> new Integer[intArr.length]);
        return intToCharArray(integers);
    }

    public static Character[] intToCharArray(Integer[] intArr) {
        return Stream.of(intArr)
                .map(x -> Character.valueOf((char) x.intValue()))
                .toArray(x -> new Character[intArr.length]);
    }

}

