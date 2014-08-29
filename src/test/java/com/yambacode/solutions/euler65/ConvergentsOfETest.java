package com.yambacode.solutions.euler65;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by cbyamba on 2014-08-24.
 */
public class ConvergentsOfETest {

    public static final Fraction _1 = Fraction.ONE;
    public static final Fraction _2 = Fraction.TWO;
    public static final Fraction _3 = Fraction.THREE;
    public static final Fraction _1_3 = Fraction.of(1, 3);
    public static final Fraction _1_2 = Fraction.of(1, 2);
    public static final Fraction _3_4 = Fraction.of(3, 4);
    public static final Fraction _4_3 = Fraction.of(4, 3);
    public static final Fraction _2_3 = Fraction.of(2, 3);
    public static final Fraction _3_2 = Fraction.of(3, 2);

    @Test
    public void testFraction() {
        Fraction _5div2 = Fraction.TWO.add(Fraction.of(1, 2));
        assertEquals(Fraction.of(5, 2), _5div2);
        assertEquals(Fraction.of(1, 2), Fraction.of(2, 4));
        Fraction _2div5 = _5div2.invert();
        assertEquals(Fraction.of(2, 5), _2div5);
        Fraction _1 = Fraction.ONE;
        assertEquals(Fraction.of(7, 5), _1.add(_2div5));

        assertEquals(Fraction.of(7, 5), Fraction.ONE.add(Fraction.TWO.add(Fraction.of(1, 2)).invert()));


    }


    @Test
    public void testAdd() {


        assertEquals(_2, _1.add(_1));
        assertEquals(_3, _1.add(_2));
        assertEquals(Fraction.of(4), _2.add(_1).add(_1));

        assertEquals(_4_3, _1_3.add(_1));
        assertEquals(_3_2, _1.add(_1_2));

    }


    /**
     * 2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536
     */
    @Test
    public void testDoFractions() {
        ConvergentsOfE e = new ConvergentsOfE();
        assertEquals(Fraction.TWO, e.doFractions(0));
        assertEquals(Fraction.THREE, e.doFractions(1));
        assertEquals(Fraction.of(8, 3), e.doFractions(2));
        assertEquals(Fraction.of(11, 4), e.doFractions(3));
        assertEquals(Fraction.of(19, 7), e.doFractions(4));
        assertEquals(Fraction.of(87, 32), e.doFractions(5));
        assertEquals(Fraction.of(106, 39), e.doFractions(6));
        assertEquals(Fraction.of(193, 71), e.doFractions(7));
        assertEquals(Fraction.of(1264, 465), e.doFractions(8));
        assertEquals(Fraction.of(1457, 536), e.doFractions(9));
    }
}
