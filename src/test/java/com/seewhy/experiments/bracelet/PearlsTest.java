package com.seewhy.experiments.bracelet;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by cbyamba on 2014-08-29.
 */
public class PearlsTest {

    public static final String[] ABCD = {"A", "B", "C", "D"};
    public static final String[] DABC = {"D", "A", "B", "C"};
    public static final String[] CDAB = {"C", "D", "A", "B"};
    public static final String[] BCDA = {"B", "C", "D", "A"};

    public static final String[][] ROTATIONS = {ABCD, DABC, CDAB, BCDA};

    public static final String[] REPEATED_LETTER = {"A", "A", "D", "C"};
    public static final String[] WRONG_ORDER = {"A", "C", "B", "D"};
    public static final String[] TOO_LONG = {"A", "C", "B", "D", "E"};
    public static final String[] NULL = null;

    /**
     * tests all unique pairs of rotated bracelets (i.e. they are all equal)
     */
    @Test
    public void testFlattenedEqualsPositive() {
        assertTrue(Pearls.flattenedEquals(ABCD, DABC));
        assertTrue(Pearls.flattenedEquals(ABCD, CDAB));
        for (int i = 1; i < ROTATIONS.length; i++) {
            for (int j = 0; j < i; j++) {
                Assert.assertTrue(Pearls.flattenedEquals(ROTATIONS[i], ROTATIONS[j]));
            }
        }
    }

    public void testFlattenedEqualsNegative() {

        assertFalse(Pearls.flattenedEquals(REPEATED_LETTER, ABCD));
        assertFalse(Pearls.flattenedEquals(WRONG_ORDER, ABCD));
        assertFalse(Pearls.flattenedEquals(TOO_LONG, ABCD));
        assertFalse(Pearls.flattenedEquals(NULL, ABCD));
    }

}
