package com.yambacode.common.collections;

import com.yambacode.common.io.Printer;
import com.yambacode.common.util.UpDownCastArrays;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-03-13.
 */
public class ArraysNDTest {

    @Test
    public void testDeepEquals() {
        int[] first = {1, 2, 3};
        int[] second = Arrays.copyOf(first, first.length);
        Assert.assertTrue(Arrays1D.deepEquals(first, second));
        second[1] = 7;
        Assert.assertFalse(Arrays1D.deepEquals(first, second));


        int[][] first2d = {{11, 12, 13}, {21, 22, 23}, {31, 32, 33}};
        int[][] copy = Arrays2D.copyOf(first2d);
        int[][] legacyCopy = Arrays.copyOf(first2d, first2d.length);
        Assert.assertTrue(Arrays.deepEquals(first2d, copy));
        Assert.assertTrue(Arrays.deepEquals(first2d, legacyCopy));

        copy[0][2] = 7;
        Assert.assertFalse(Arrays.deepEquals(first2d, copy));
        Assert.assertFalse(Arrays2D.deepEquals(first2d, copy));//TODO remove?? LEGACY ARRAYS DEEP EQUALS SEEMS TO BE DEEP FOR REAL SO THIS IS REDUNDANT
        Printer.print(Arrays.deepToString(copy));


        legacyCopy[0][2] = 7;
        Printer.print("----- LEGACY VS ARRAYS2D ----");
        Printer.print(Arrays.deepToString(first2d));
        Printer.print(Arrays.deepToString(legacyCopy));
        //Assert.assertFalse(Arrays.deepEquals(first2d, legacyCopy)); //LEGACY ARRAYS DOES NOT IMPLEMENTS DEEP COPY ON ARRAYS LARGER THAN 1 dimension.
        //Assert.assertFalse(Arrays2D.deepEquals(first2d, legacyCopy));
        Printer.print(Arrays.deepToString(legacyCopy));

    }

    @Test
    public void testGetRow() {
        int[][] array2d1 = {{11, 12, 13}, {21, 22, 23}, {31, 32, 33}};

        int[] a1 = {11, 12, 13};
        int[] a2 = Arrays2D.getRow(array2d1, 1);
        Arrays.deepEquals(UpDownCastArrays.upCast(a1), UpDownCastArrays.upCast(a2));

        int[][] array2d2 = {{11, 12, 13}, {21, 22, 23}, {31, 32, 33}};
        int[][] copy = Arrays2D.copyOf(array2d2);
        Printer.print(Arrays2D.deepEquals(array2d1, copy));

    }

    @Test
    public void testDiagonals() {
        int[][] array2d1 = {
                {11, 12, 13},
                {21, 22, 23},
                {31, 32, 33}
        };
        int[] dia1 = Arrays2D.subDiagonalsNESW(array2d1, 0);
        int[] expected = {13};
        Assert.assertEquals(expected[0], dia1[0]);

        int[] dia2 = Arrays2D.subDiagonalsNESW(array2d1, 1);
        int[] expected2 = {12, 23};
        Assert.assertEquals(expected2[0], dia2[0]);
        Assert.assertEquals(expected2[1], dia2[1]);

        int[] dia3 = Arrays2D.subDiagonalsNESW(array2d1, 2);
        int[] expected3 = {11, 22, 33};
        Assert.assertEquals(expected3[0], dia3[0]);
        Assert.assertEquals(expected3[1], dia3[1]);
        Assert.assertEquals(expected3[2], dia3[2]);

        int[] dia4 = Arrays2D.subDiagonalsNESW(array2d1, 3);
        int[] expected4 = {21, 32};
        Assert.assertEquals(expected4[0], dia4[0]);
        Assert.assertEquals(expected4[1], dia4[1]);

        int[] dia5 = Arrays2D.subDiagonalsNESW(array2d1, 4);
        int[] expected5 = {31};
        Assert.assertEquals(expected5[0], dia5[0]);

        //=======

        int[] dia6 = Arrays2D.subDiagonalsNWSE(array2d1, 0);
        int[] expected6 = {11};
        Assert.assertEquals(expected6[0], dia6[0]);

        int[] dia7 = Arrays2D.subDiagonalsNWSE(array2d1, 1);
        int[] expected7 = {12, 21};
        Assert.assertEquals(expected7[0], dia7[0]);
        Assert.assertEquals(expected7[1], dia7[1]);

        int[] dia8 = Arrays2D.subDiagonalsNWSE(array2d1, 2);
        int[] expected8 = {13, 22, 31};
        Assert.assertEquals(expected8[0], dia8[0]);
        Assert.assertEquals(expected8[1], dia8[1]);
        Assert.assertEquals(expected8[2], dia8[2]);

        int[] dia9 = Arrays2D.subDiagonalsNWSE(array2d1, 3);
        int[] expected9 = {23, 32};
        Assert.assertEquals(expected9[0], dia9[0]);
        Assert.assertEquals(expected9[1], dia9[1]);

        int[] dia10 = Arrays2D.subDiagonalsNWSE(array2d1, 4);
        int[] expected10 = {33};
        Assert.assertEquals(expected10[0], dia10[0]);

        //undefined
        Assert.assertEquals(0, Arrays2D.subDiagonalsNESW(array2d1, 100).length);
        Assert.assertEquals(0, Arrays2D.subDiagonalsNWSE(array2d1, 100).length);
    }

    @Test
    public void testPermutations() {
        int[][] permutationArray = {
                {1, 0, 0},
                {0, 2, 0},
                {0, 0, 3}
        };
        Comparable[] permutation = Arrays2D.toPermutation(permutationArray);
        Assert.assertEquals(permutation[0], permutationArray[0][0]);
        Assert.assertEquals(permutation[1], permutationArray[1][1]);
        Assert.assertEquals(permutation[2], permutationArray[2][2]);

        Comparable[] permutation1 = Arrays2D.toPermutation(permutationArray);
        Printer.print(permutation1);
        Arrays2D.fromPermutation(permutation1);
    }

    private void testRowsEquals(int[] expected, int[] actual) {
        IntStream.range(0, expected.length)
                .forEachOrdered(i -> testEntryEquals(expected[i], actual[i]));
    }

    private void testEntryEquals(int expected, int actual) {
        Assert.assertEquals(expected, actual);
    }

    private void testAllEquals(int[][] expected, int[][] actual) {
        IntStream.range(0, expected.length)
                .forEachOrdered(i -> testRowsEquals(expected[i], actual[i]));
    }
}
