package com.yambacode.common.collections;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by christopheryamba on 20/02/16.
 */
public class Arrays1DTest {

    @Test
    public void shouldReturnTrueWhenBothArraysAreNull() {
        assertTrue(Arrays1D.deepEquals(null, null));
    }

    @Test
    public void shouldReturnFalseWhenOneArrayIsNull() {
        int[] a = {1, 2, 3, 4};
        assertFalse(Arrays1D.deepEquals(null, a));
    }

    @Test
    public void shouldReturnFalseWhenDifferentLengths() {
        int[] a = {1, 2, 3, 4};
        int[] b = {1, 2, 3};
        assertFalse(Arrays1D.deepEquals(a, b));

    }

    @Test
    public void shouldReturnTrueWhenEqualElements() {
        int[] a = {1, 2, 3, 4};
        int[] b = {1, 2, 3, 4};
        assertTrue(Arrays1D.deepEquals(a, b));
    }

    @Test
    public void shouldReturnFalseWhenNotEqualElements() {
        int[] a = {1, 2, 0, 4};
        int[] b = {1, 2, 3, 4};
        assertFalse(Arrays1D.deepEquals(a, b));
    }

}