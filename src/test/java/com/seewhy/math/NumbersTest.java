package com.seewhy.math;

import static junit.framework.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import static java.util.Arrays.*;

import static com.seewhy.common.io.Printer.*;
import static com.seewhy.math.Numbers.*;

/**
 * Created by cbyamba on 2014-02-13.
 */
public class NumbersTest {

    /**
     * Triangle
     * n(n+1)/2
     * 1, 3, 6, 10, 15, ...
     */
    @Test
    public void testTriangleNumbers() {
        assertEquals(1, triangularNumber(1));
        assertEquals(3, triangularNumber(2));
        assertEquals(6, triangularNumber(3));
        assertEquals(10, triangularNumber(4));
        assertEquals(15, triangularNumber(5));
        //assertEquals(asList(1, 3, 6, 10, 15), triangularNumbersLessThan(1, 15));
        assertEquals(asList(1, 3, 6, 10, 15), triangleNumbersRangeClosed(1, 5));

        //assertTrue(isTriangularNumber(10));
        //assertTrue(isTriangularNumber(15));

        assertTrue(isTriangleGeneralized(10));
        assertTrue(isTriangleGeneralized(15));

        assertTrue(areTriangleNumbers(1, 3, 6, 10, 15));

        //negative cases
        assertFalse(isTriangleGeneralized(11));
        assertFalse(isTriangleGeneralized(16));
        assertFalse(areTriangleNumbers(1, 2, 6, 15));
    }

}
