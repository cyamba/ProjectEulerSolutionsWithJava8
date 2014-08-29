package com.seewhy.experiments.bracelet;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static com.seewhy.experiments.bracelet.PearlsTest.*;

/**
 * Created by cbyamba on 2014-08-29.
 */
public class BraceletTest {

    @Test
    public void testBraceletEqualsPositive() {

        assertTrue(Bracelet.of(ABCD).equals(Bracelet.of(ABCD)));
        assertTrue(Bracelet.of(ABCD).equals(Bracelet.of(DABC)));
        assertTrue(Bracelet.of(ABCD).equals(Bracelet.of(CDAB)));
        assertTrue(Bracelet.of(ABCD).equals(Bracelet.of(BCDA)));
    }

    @Test
    public void testBraceletEqualsNegative() {

        assertFalse(Bracelet.of(ABCD).equals(Bracelet.of(REPEATED_LETTER)));
        assertFalse(Bracelet.of(ABCD).equals(Bracelet.of(WRONG_ORDER)));
        assertFalse(Bracelet.of(ABCD).equals(Bracelet.of(TOO_LONG)));
        assertFalse(Bracelet.of(ABCD).equals(Bracelet.of(NULL)));
    }
}
