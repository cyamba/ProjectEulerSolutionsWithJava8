package com.yambacode.solutions.euler51;

import java.util.List;
import java.util.function.Consumer;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by cbyamba on 2014-02-20.
 */
public class PrimeDigitReplacementImperativeTest {

    PrimeDigitReplacementImperative primeDigitReplacement = new PrimeDigitReplacementImperative();


    @Test
    public void testTransformNumber() {
        Consumer<Long> transformNumberBlock = (number) -> {
            List<Long> numbers = primeDigitReplacement.transformNumber(number, new int[]{1, 2, 3});
            Assert.assertEquals(Long.valueOf(number), numbers.get(0));
        };
        time(transformNumberBlock);
    }

    public void time(Consumer<Long> voidFunction) {
        long start = System.currentTimeMillis();
        voidFunction.accept(10001L);
        long executionTime = System.currentTimeMillis() - start;
        System.out.println(String.format("executionTime : %s ms", executionTime));
    }
}
