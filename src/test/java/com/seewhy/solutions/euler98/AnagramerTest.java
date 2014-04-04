package com.seewhy.solutions.euler98;

import com.seewhy.common.io.Printer;
import com.seewhy.math.Permutations;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by cbyamba on 2014-04-02.
 */
public class AnagramerTest {

    @Test
    public void testReArrange() {
        String[] w1 = {"a", "b", "c"};
        Integer[] f1 = {0, 1, 2};
        Integer[] f2 = {2, 1, 0};
        Integer[] f3 = {1, 0, 2};
        String[] f3Answer = {"b", "a", "c"};
        Assert.assertArrayEquals(f3Answer, Anagramer.reArrangeWith(w1, f3));

        Printer.print(); //TODO a computer language with return type chosen without changing signature

    }
}
