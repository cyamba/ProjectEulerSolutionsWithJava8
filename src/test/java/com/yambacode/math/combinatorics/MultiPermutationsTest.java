package com.yambacode.math.combinatorics;

import com.yambacode.common.io.Printer;
import com.yambacode.math.combinatorics.MultiPermutations;
import com.yambacode.math.combinatorics.Permutation;
import com.yambacode.math.combinatorics.Permutations;
import com.yambacode.math.combinatorics.Word;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by cbyamba on 2014-04-02.
 */
public class MultiPermutationsTest {

    @Test
    public void testMultiply() {
        String[] multiPermutation1 = {"1", "2", "2", "3"};
        Integer[] factor = {1, 2, 4, 3};
        String[] expected = {"1", "2", "3", "2"};
        Assert.assertTrue(Arrays.deepEquals(expected, MultiPermutations.multipy(multiPermutation1, Permutations.toIndicesPermutation(factor))));
    }

    @Test
    public void testGetMappings() {
        String[] multiPermutation1 = {"A", "A", "B", "B", "C"};
        Map<Word, List<Permutation>> permutationMapping = MultiPermutations.getPermutationMapping(Word.of(multiPermutation1));
        permutationMapping.entrySet().stream().forEach(
                e -> Printer.print("key : " + Arrays.deepToString(e.getKey().get()) + " value : " + Arrays.deepToString(e.getValue().toArray()))
        );

    }

    @Test
    public void testGetDiff() {
        String[] multiPermutation1 = {"A", "A", "B", "B", "C"};
        List<Permutation> factorsForPermutation = MultiPermutations.getFactorsForPermutation(Word.of(multiPermutation1), Word.of(multiPermutation1));
        Printer.print(factorsForPermutation.toArray());
    }

}
