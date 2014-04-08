package com.seewhy.math;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by cbyamba on 2014-04-08.
 */
public class WordTest {

    @Test
    public void testWord() {
        Word word1 = Word.of("A", "A", "B", "B", "C");
        Word word2 = Word.of("A", "A", "B", "B", "C");
        Assert.assertEquals(word1, word2);
        Assert.assertFalse(word1.equals(Word.of("A", "A", "C", "B", "B", "C")));
    }
}
