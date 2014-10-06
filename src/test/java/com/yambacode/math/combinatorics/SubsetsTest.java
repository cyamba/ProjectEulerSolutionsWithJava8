package com.yambacode.math.combinatorics;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cbyamba on 2014-10-06.
 */
public class SubsetsTest {

    @Test
    public void testPositive() {
        Assert.assertEquals(16, Subsets.subsets(4));
        Assert.assertEquals(32, Subsets.subsets(5));
        Assert.assertEquals(64, Subsets.subsets(6));
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
