package com.seewhy.experiments.bracelet;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static com.seewhy.experiments.bracelet.PearlsTest.*;

/**
 * Created by cbyamba on 2014-08-29.
 */
public class BraceletTest {

    @Test
    public void testBraceletEquals() {
        assertTrue(Bracelet.of(ABCD).equals(Bracelet.of(DABC)));
        assertTrue(Bracelet.of(ABCD).equals(Bracelet.of(CDAB)));
        assertTrue(Bracelet.of(ABCD).equals(Bracelet.of(DABC)));
    }
}
