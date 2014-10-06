package com.yambacode.math.combinatorics;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by cbyamba on 2014-10-06.
 */
public class CompositionsTest {

    @Test
    public void testPositive() {
        Assert.assertEquals(16, Compositions.compositionsOf(5).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeOnNumber() {
        Compositions.compositionsOf(-1);
    }
}
