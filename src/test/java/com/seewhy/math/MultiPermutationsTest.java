package com.seewhy.math;

import junit.framework.Assert;
import org.junit.Test;

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

}
