package com.seewhy.solutions.euler38;

import static com.seewhy.common.util.NumberStringConversions.*;

import com.seewhy.solutions.AbstractEulerSolver;

import static java.util.stream.Collectors.*;

import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-01-20.
 */
public class PandigitalMultiples extends AbstractEulerSolver {


    public boolean isPanDigital(int number) {
        String[] numberStringArray = intToStringArray(number);
        return Stream.of(numberStringArray).sorted().collect(joining()).equals("123456789");
    }

    //TODO DO
    @Override
    public String doSolve() {
        return "" + isPanDigital(132498675);
    }
}
