package com.yambacode.solutions.euler58;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cbyamba on 2014-03-07.
 */
public class PrimeSpiralTest {

    PrimeSpiral euler58 = new PrimeSpiral();

    /**
     * 17 16 15 14  13
     * 18 5  4  3   12
     * 19 6  1  2   11
     * 20 7  8  9   10
     * 21 22 23 24  25
     */
    @Test
    public void testDiagonals() {

        assertEquals(1, euler58.se(0));
        assertEquals(1, euler58.ne(0));
        assertEquals(1, euler58.nw(0));
        assertEquals(1, euler58.sw(0));

        assertEquals(9, euler58.se(1));
        assertEquals(3, euler58.ne(1));
        assertEquals(5, euler58.nw(1));
        assertEquals(7, euler58.sw(1));

        assertEquals(25, euler58.se(2));
        assertEquals(13, euler58.ne(2));
        assertEquals(17, euler58.nw(2));
        assertEquals(21, euler58.sw(2));

    }
}
