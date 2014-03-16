package com.seewhy.common.collections;

import com.seewhy.common.io.Printer;
import com.seewhy.common.util.UpDownCastArrays;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * Created by cbyamba on 2014-03-13.
 */
public class Arrays2D {

    public static int[] getRow(int[][] array2d, int row) {
        return array2d[row];
    }

    public static int[] getColumn(int[][] array2d, int column) {
        return IntStream.range(0, array2d.length).map(i -> array2d[i][column]).toArray();
    }

    public static int[] getDiagonalFromNorthWest(int[][] array2d) {
        return IntStream.range(0, array2d.length)
                .map(i -> array2d[i][i])
                .toArray();
    }

    public static int[] getDiagonalFromNorthEast(int[][] array2d) {
        int length = array2d.length;
        return IntStream.range(0, length)
                .map(i -> array2d[(length - 1) - i][(length - 1) - i])
                .toArray();
    }

    /**
     * {11, 12, 13},
     * {21, 22, 23},
     * {31, 32, 33}
     *
     * @param array2d
     * @param startNW where 0 is North East corner
     * @return In above example 2 returns [13,22,31]
     */
    public static int[] subDiagonalsNWSE(int[][] array2d, int startNW) {
        int length = array2d.length;
        if (startNW >= length) {
            int end = 2 * length - startNW - 2;
            int start = startNW - length + 1;
            return IntStream.rangeClosed(0, end)
                    .map(x -> array2d[start + x][length - 1 - x])
                    .toArray();
        }
        if (startNW >= 2 * length - 2) {
            return array2d[0];
        }
        return IntStream.rangeClosed(0, startNW)
                .map(x -> array2d[x][startNW - x])
                .toArray();
    }

    /**
     * 11 12 13
     * 21 22 23
     * 31 32 33
     *
     * @param array2d
     * @param startNE
     * @return 2 returns {11,22,33}
     */
    public static int[] subDiagonalsNESW(int[][] array2d, int startNE) {
        int length = array2d.length;
        if (startNE >= length) {
            int start = startNE - length + 1;
            int end = length - start - 1;
            return IntStream.rangeClosed(0, end)
                    .map(x -> array2d[start + x][x])
                    .toArray();
        }
        if (startNE >= 2 * length - 1) {
            return array2d[0];
        }
        return IntStream.rangeClosed(0, startNE)
                .map(x -> array2d[x][length - startNE - 1 + x])
                .toArray();
    }


    public static int[][] toArray(List<int[]> list) {
        int length = list.size();
        int[][] result = new int[length][];
        IntStream.range(0, length)
                .forEachOrdered(x -> result[x] = list.get(x));
        return result;
    }


    public static List<int[]> toList(int[][] a1) {
        return IntStream.range(0, a1.length).mapToObj(i -> a1[i]).collect(Collectors.toList());
    }

    public static int[][] merge(int[][] a1, int[][] a2) {
        List<int[]> a1AsList = toList(a1);
        List<int[]> a2AsList = toList(a2);
        a1AsList.addAll(a2AsList);
        return toArray(a1AsList);
    }

    public static int[][] getAllSubDiagonals(int[][] array2d) {
        int[][] nwseDiagonals = getSubDiagonals(array2d, x -> subDiagonalsNWSE(array2d, x));
        int[][] neswDiagonals = getSubDiagonals(array2d, x -> subDiagonalsNESW(array2d, x));
        return merge(nwseDiagonals, neswDiagonals);
    }

    public static List<int[]> getAllSubDiagonalsAsList(int[][] array2d) {
        return toList(getAllSubDiagonals(array2d));
    }


    public static int[][] getAllSubDiagonalsNWSE(int[][] array2d) {
        return getSubDiagonals(array2d, x -> subDiagonalsNWSE(array2d, x));
    }

    public static int[][] getAllSubDiagonalsNESW(int[][] array2d) {
        return getSubDiagonals(array2d, x -> subDiagonalsNESW(array2d, x));
    }

    public static int[][] getSubDiagonals(int[][] array2d, IntFunction<? extends int[]> subDiagonalsLambda) {
        int length = array2d.length * 2 - 2;
        List<int[]> diagonals = IntStream.rangeClosed(0, length)
                .mapToObj(subDiagonalsLambda)
                .collect(Collectors.toList());
        return toArray(diagonals);
    }

    public static boolean deepEquals(int[][] first, int[][] second) {
        if (first.length != second.length) {
            return false;
        }
        return IntStream.range(0, first.length)
                .peek(x -> {
                    Printer.print(first[x]);
                    Printer.print(second[x]);
                })
                .allMatch(i -> Arrays.deepEquals(UpDownCastArrays.upCast(first[i]),
                        UpDownCastArrays.upCast(second[i])));
    }

    public static int[][] copyOf(int[][] original) {
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = Arrays.copyOf(original[i], original.length);
        }
        return copy;
    }

    /**
     * @param permutation a permutation of length n of integers from 0 to n-1
     * @return the corresponding matrix
     */
    public static int[][] fromPermutation(final Comparable[] permutation) {
        int length = permutation.length;
        int[][] result = new int[length][];
        Comparable[] newPermutation = sanatizePermutation(permutation);

        IntStream.range(0, length)
                .forEachOrdered(i -> {
                    int[] tmp = new int[length];
                    tmp[(int) newPermutation[i]] = 1;
                    result[i] = tmp;
                });
        return result;
    }

    //TODO  move to permutation
    protected static Integer[] sanatizePermutation(Comparable[] permutation) {
        Map<Comparable, Comparable> map = Maps.toMap(permutation);
        TreeMap<Comparable, Comparable> sortedMap = new TreeMap<>(Maps.inverse(map));
        Map<Comparable, Comparable> sanatizedMap = IntStream
                .range(0, sortedMap.size())
                .boxed()
                .collect(Collectors.toMap(x -> x, x -> Maps.asList(sortedMap).get(x)));
        List<Comparable> list = Maps.asList(Maps.inverse(sanatizedMap));
        return list.stream().mapToInt(x -> (int) x).boxed().toArray(x -> new Integer[list.size()]);
    }

    public static Comparable[] toPermutation(int[][] array2d) {
        int length = array2d.length;
        return IntStream.range(0, length)
                .mapToObj(i -> getPermutationValue(getRow(array2d, i)))
                .toArray(x -> new Integer[length]);
    }

    protected static int getPermutationValue(int[] row) {
        return IntStream.of(row).filter(x -> x != 0).findFirst().getAsInt();
    }

    public static String deepToString(int[][] array2d) {
        return IntStream.range(0, array2d.length)
                .mapToObj(x -> Arrays.toString(array2d[x]))
                .collect(joining("\n"));
    }

    public static Integer[][] upcast(int[][] array2d) {
        return null; //TODO
    }

}
