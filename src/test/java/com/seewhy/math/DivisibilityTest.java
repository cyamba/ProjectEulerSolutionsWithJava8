package com.seewhy.math;

import com.seewhy.common.collections.Lists;
import com.seewhy.solutions.euler65.Fraction;
import com.seewhy.solutions.euler97.BigIntegers;
import org.junit.Test;

import java.math.BigInteger;
import java.util.stream.LongStream;

import static com.seewhy.math.Divisibility.gcd;
import static com.seewhy.math.Divisibility.totients;
import static java.util.Arrays.deepToString;
import static junit.framework.Assert.assertEquals;

/**
 * Created by cbyamba on 2014-02-13.
 */
public class DivisibilityTest {

    @Test
    public void testCoprime() {
        assertEquals(String.format("gcd(6,4)=2"), 2, gcd(6, 4));
    }

    @Test
    public void testGCD() {
        assertEquals(1, gcd(17, 41));
    }

    @Test
    public void testTotient() {
        long[] totients = totients(2, 10);
        long[] expected = {1, 2, 2, 4, 2, 6, 4, 6, 4};

        Long[] totientsObjects = LongStream.of(totients).boxed().toArray(x -> new Long[totients.length]);
        Long[] expectedObjects = LongStream.of(expected).boxed().toArray(x -> new Long[expected.length]);

        assertEquals(String.format("%s", deepToString(totientsObjects)), deepToString(expectedObjects), deepToString(totientsObjects));
    }

    @Test
    public void testPrimeFraction() {
        //1/2
        assertEquals(Fraction.of(1, 2), Divisibility.primeFraction(BigIntegers.TWO));
        //1/3
        assertEquals(Fraction.of(1, 3), Divisibility.primeFraction(BigIntegers.THREE));

        assertEquals(Fraction.ONE, Divisibility.totient(Lists.of(BigIntegers.TWO)));

        assertEquals(Fraction.TWO, Divisibility.totient(Lists.of(BigIntegers.THREE)));
        assertEquals(Fraction.THREE, Divisibility.totient(Lists.of(BigIntegers.FOUR)));
        assertEquals(Fraction.FOUR, Divisibility.totient(Lists.of(BigIntegers.FOUR)));

    }
}
