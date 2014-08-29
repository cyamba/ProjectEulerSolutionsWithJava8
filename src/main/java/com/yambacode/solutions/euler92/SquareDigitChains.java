package com.yambacode.solutions.euler92;

import com.yambacode.solutions.AbstractEulerSolver;

import static com.yambacode.solutions.EulerRunner.*;

import java.util.stream.IntStream;

import static com.yambacode.common.util.NumberStringConversions.intToIntArray;

/**
 * Created by cbyamba on 2014-02-14.
 */
public class SquareDigitChains extends AbstractEulerSolver {

    public static final int SIZE = 10_000_000;

    protected boolean chainTerminalNumber(int number) {
        if (number == 1) {
            return false;
        }
        if (number == 89) {
            return true;
        }
        return chainTerminalNumber(sumOfDigitsSquared(number));
    }

    protected int sumOfDigitsSquared(int number) {
        return IntStream.of(intToIntArray(number)).map(x -> x * x).sum();
    }

    @Override
    public String doSolve() {
        return "" +
                IntStream
                        .range(1, SIZE)
                        .parallel()
                        .filter(this::chainTerminalNumber)
                        .count();
    }

    public static void main(String... args) {
        runEulerSolvers(new SquareDigitChains());
    }
}
