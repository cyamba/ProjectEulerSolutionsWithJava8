package com.yambacode.solutions.euler57;

import com.yambacode.solutions.AbstractEulerSolver;

import static com.yambacode.solutions.EulerRunner.runEulerSolvers;

import java.util.stream.IntStream;

import static com.yambacode.solutions.euler57.Fraction.fraction;

/**
 * Created by cbyamba on 2014-02-21.
 */
public class SquareRootConvergents extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        return "" + IntStream.rangeClosed(0, 1000)
                .parallel()
                .mapToObj(i -> compute(fraction(1, 2), 0, i))
                .filter(fraction -> numeratorExceedsDenominator(fraction))
                .count();
    }

    private boolean numeratorExceedsDenominator(Fraction fraction) {
        return fraction.getNumerator().toString().length() > fraction.getDenominator().toString().length();
    }

    public static Fraction compute(Fraction fraction, int count, int max) {
        if (count == max) {
            return fraction.add(1);
        }
        return compute(fraction.add(2).inv(), ++count, max);
    }

    public static void main(String... args) {
        runEulerSolvers(new SquareRootConvergents());
    }
}
