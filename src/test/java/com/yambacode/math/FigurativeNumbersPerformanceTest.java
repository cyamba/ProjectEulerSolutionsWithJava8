package com.yambacode.math;

import com.yambacode.common.io.Printer;
import org.junit.Test;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-02-13.
 */
public class FigurativeNumbersPerformanceTest {

    @Test
    public void testPerformance() {
        //times(1000, Numbers::isTriangleGeneralized, Numbers::isTriangularNumber);
        times(100000, FigurativeNumbers::isTriangularNumber, FigurativeNumbers::isTriangleGeneralized);

        //times();
    }


    private void times(int arg, Function<Integer, Boolean>... functions) {
        Stream.of(functions).forEach(function -> time(function, arg));
    }

    private void time(Function<Integer, Boolean> function, int arg) {
        long start = System.currentTimeMillis();
        function.apply(arg);
        Printer.print(String.format("executionTime of %s is %s ms", function.getClass(), System.currentTimeMillis() - start));
    }
}
