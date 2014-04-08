package com.seewhy.math;

import com.seewhy.common.io.Printer;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by cbyamba on 2014-04-02.
 */
public class MultiPermutationsTest {

    @Test
    public void testMultiply() {
        String[] multiPermutation1 = {"1", "2", "2", "3"};
        Integer[] factor = {1, 2, 4, 3};
        String[] expected = {"1", "2", "3", "2"};
        Assert.assertEquals(expected, MultiPermutations.multipy(multiPermutation1, Permutations.toIndicesPermutation(factor)));
    }

    @Test
    public void testGetMappings() {
        String[] multiPermutation1 = {"A", "A", "B", "B", "C"};
        Map<Word, List<Permutation>> permutationMapping = MultiPermutations.getPermutationMapping(Word.of(multiPermutation1));
        permutationMapping.entrySet().stream().forEach(
                e -> Printer.print("key : " + Arrays.deepToString(e.getKey().get()) + " value : " + Arrays.deepToString(e.getValue().toArray()))
        );
    }

}
