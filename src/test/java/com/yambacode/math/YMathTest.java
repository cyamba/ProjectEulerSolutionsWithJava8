package com.yambacode.math;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by cbyamba on 2014-10-10.
 */
public class YMathTest {


    @Test
    public void log() {
        Assert.assertEquals(Double.NaN, YMath.log(1, 1));
        Assert.assertEquals(Double.POSITIVE_INFINITY, YMath.log(2, 1));
    }
}
