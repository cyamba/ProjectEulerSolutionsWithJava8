package com.yambacode.solutions.euler57;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by cbyamba on 2014-03-03.
 */
public class FractionTest {

    @Test
    public void testFactions() {

        Assert.assertEquals(Fraction.fraction(1, 1), Fraction.fraction(1));
        Assert.assertEquals(Fraction.fraction(2, 1), Fraction.fraction(2));

        Assert.assertEquals(Fraction.fraction(2, 1).inv().inv(), Fraction.fraction(2, 1));
        Assert.assertEquals(Fraction.fraction(1, 2).inv(), Fraction.fraction(2, 1));

        Assert.assertEquals(Fraction.fraction(1, 2), Fraction.fraction(2, 4));

        Assert.assertEquals(Fraction.fraction(1 / 2).add(Fraction.fraction(2, 2)), Fraction.fraction(3, 2));
        Assert.assertEquals(Fraction.fraction(1 / 2).add(2), Fraction.fraction(3, 2));
    }
}
