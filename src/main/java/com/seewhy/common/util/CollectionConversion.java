package com.seewhy.common.util;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-01-13.
 */
public class CollectionConversion {

    public static Character[] mapToCharacterArray(char[] chars) {
        Character[] characters = new Character[chars.length];
        for (int i = 0; i < characters.length; i++) {
            characters[i] = chars[i];
        }
        return characters;
    }

    public static int[] bigIntegerToDigits(BigInteger number) {
        String numberStr = number.toString();
        int[] result = new int[numberStr.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.valueOf(numberStr.substring(i, i + 1));
        }
        return result;
    }

    public static long[] toPrimitiveLongArray(Comparable[] arr) {
        return Stream.of(arr).filter(x -> x != null).mapToLong(x -> (long) x).toArray();
    }

    public static long[][] toLong2dArray(Comparable[][] permutationArray) {
        long[][] result = new long[permutationArray.length][permutationArray[0].length];
        IntStream.range(0, permutationArray.length).forEach(i -> result[i] = toPrimitiveLongArray(permutationArray[i]));
        return result;
    }
}
