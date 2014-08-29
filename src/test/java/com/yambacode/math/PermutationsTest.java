package com.yambacode.math;

import com.yambacode.common.io.Printer;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-04-03.
 */
public class PermutationsTest {

    @Test
    public void testDiff() {
        Comparable[] permutation = {"A", "D", "T", "C", "E"};
        Integer[] indicesPermutation = Permutations.toIndicesPermutation(permutation);
        Printer.print(indicesPermutation);
        Integer[] expected = {0, 2, 4, 1, 3};
        Assert.assertArrayEquals(expected, indicesPermutation);
    }

    @Test
    public void testExperimentsWithSquaresAndPermutations(){
        String word = "EDUCE";
        Printer.print(IntStream.range(100, 200).map(x -> x * x).toArray());
    }
}
