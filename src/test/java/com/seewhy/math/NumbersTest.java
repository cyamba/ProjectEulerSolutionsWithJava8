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

    /**
     * Triangle 	  	P3,n=n(n+1)/2 	  	1, 3, 6, 10, 15, ...
     * Square 	  	    P4,n=n2 	  	1, 4, 9, 16, 25, ...
     * Pentagonal 	  	P5,n=n(3n−1)/2 	  	1, 5, 12, 22, 35, ...
     * Hexagonal 	  	P6,n=n(2n−1) 	  	1, 6, 15, 28, 45, ...
     * Heptagonal 	  	P7,n=n(5n−3)/2 	  	1, 7, 18, 34, 55, ...
     * Octagonal 	  	P8,n=n(3n−2) 	  	1, 8, 21, 40, 65, ...
     */
    @Test
    public void testFigurativeNumbers() {

    }

}
