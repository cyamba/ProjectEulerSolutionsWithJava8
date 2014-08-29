package com.yambacode.common.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by cbyamba on 2014-02-20.
 */
public class DigitTransformationsTest {

    @Test
    public void testReplaceWith() {
        Integer newNumber = DigitTransformations.replaceWith(11111, new int[]{1, 2, 3}, 0);
        assertEquals("", Integer.valueOf(10001), newNumber);

    }

    private static final Integer[] expectedNumbers =
            {
                    10001, 11111, 12221, 13331, 14441, 15551, 16661, 17771, 18881, 19991
            };

    @Test
    public void testReplaceDigitsWith0To9() {
        List<Integer> newNumbers = DigitTransformations.replaceDigitsWith0To9(11111, new int[]{1, 2, 3});
        assertTrue(Arrays.deepEquals(newNumbers.toArray(new Integer[expectedNumbers.length]), expectedNumbers));
    }
}
