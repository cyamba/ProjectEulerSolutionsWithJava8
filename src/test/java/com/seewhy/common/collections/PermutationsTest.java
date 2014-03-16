package com.seewhy.common.collections;

import com.seewhy.common.io.Printer;
import com.seewhy.math.Permutations;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by cbyamba on 2014-03-15.
 */
public class PermutationsTest {

    @Test
    public void testInvert() {
        Integer[] permutation = {3, 1, 4, 2, 0};
        Comparable[] actual = Permutations.invert(permutation);
        Integer[] expected = {4,1,3,0,2};
        CollectionAsserts.assertEquals(expected, actual);
        Printer.print(actual);
    }


}
