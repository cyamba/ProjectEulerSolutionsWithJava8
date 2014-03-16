package com.seewhy.solutions.euler40;

import com.seewhy.solutions.AbstractEulerSolver;

import java.util.stream.Collectors;

import static com.seewhy.common.util.NumberStringConversions.stringToStringArray;
import static java.util.stream.LongStream.range;
import static java.util.stream.Stream.of;

/**
 * Created by cbyamba on 2014-01-20.
 */
public class ChampernownesConstant extends AbstractEulerSolver {

    public static final int SIZE = 1000000;

    public String champernownesConstant() {
        return range(1, SIZE)
                .parallel()
                .mapToObj(x -> String.valueOf(x)).collect(Collectors.joining());
    }

    public Long multiply(String... digits) {
        return of(digits)
                .mapToLong(d -> Long.valueOf(d))
                .reduce(1l, (x, y) -> x * y);
    }

    @Override
    public String doSolve() {
        final String[] ccArr = stringToStringArray(champernownesConstant());
        return multiply(ccArr[0], ccArr[9], ccArr[99], ccArr[999], ccArr[9999], ccArr[99999], ccArr[999999]).toString();
    }

    public static void main(String... args) {
        new ChampernownesConstant().solve();
    }
}
