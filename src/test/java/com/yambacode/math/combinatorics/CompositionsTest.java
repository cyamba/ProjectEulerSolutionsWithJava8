package com.yambacode.math.combinatorics;

import com.yambacode.common.io.Printer;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by cbyamba on 2014-10-06.
 */
public class CompositionsTest {

    @Test
    public void testPositive() {
        int[][] compositions = Compositions.compositionsOf(5);
        Assert.assertEquals(16, compositions.length);
        Printer.print(compositions);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeOnNumber() {
        Compositions.compositionsOf(-1);
    }
}
