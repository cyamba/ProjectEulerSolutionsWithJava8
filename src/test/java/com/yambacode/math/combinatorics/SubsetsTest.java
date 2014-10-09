package com.yambacode.math.combinatorics;

import com.yambacode.common.io.Printer;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cbyamba on 2014-10-06.
 */
public class SubsetsTest {

    @Test
    public void testPositive() {
        Assert.assertEquals(16, Subsets.subsets(4).length);
        Assert.assertEquals(32, Subsets.subsets(5).length);
        int[][] subsets = Subsets.subsets(6);
        Assert.assertEquals(64, subsets.length);
        Printer.print(subsets);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeOnLength() {
        Subsets.subsets(-10);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeOnNumberVsLength(){
        Subsets.toSubset(4, 17);
    }


}
