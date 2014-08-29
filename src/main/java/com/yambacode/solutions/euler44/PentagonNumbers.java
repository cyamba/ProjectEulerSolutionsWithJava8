package com.yambacode.solutions.euler44;


import com.yambacode.solutions.AbstractEulerSolver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static com.yambacode.math.Numbers.*;

/**
 * Created by cbyamba on 2014-02-03.
 */
public class PentagonNumbers extends AbstractEulerSolver {

    //TODO with flatmap of handshakes...
    @Override
    public String doSolve() {
        String s = doSolve2();
        if (s != null) {
            return s;
        }
        Integer min = 10000000;
        List<Integer> penta = pentagonalNumbersLessThanImperative(10000000);
        for (int i = 0; i < penta.size(); i++) {
            for (int j = 0; j < i; j++) {
                int p1 = penta.get(i);
                int p2 = penta.get(j);
                int diff = p1 - p2;
                int sum = p1 + p2;
                if (isPentagonal(diff) && isPentagonal(sum)) {
                    int candidate = Math.abs(diff);
                    if (candidate < min) {
                        min = candidate;
                    }
                }
            }
        }
        return min.toString();
    }


    //  @Override
    public String doSolve2() {
        // IntFunction<? extends IntStream> mapper = y -> pentagonalNumbersLessThanImperative(y).stream();
        Object[] objects = IntStream
                .range(1, 100)
                .mapToObj(x -> pentagonalNumber(x))
                .flatMap(y -> pentagonalNumbersLessThanImperative(y).stream())
                .toArray();
        return Arrays.toString(objects);
    }
}
