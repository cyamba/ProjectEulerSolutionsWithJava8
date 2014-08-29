package com.yambacode.solutions.euler33;

import com.yambacode.common.io.Printer;
import com.yambacode.solutions.AbstractEulerSolver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import static com.yambacode.common.util.NumberStringConversions.intToStringArray;
import static com.yambacode.math.Divisibility.gcd;

/**
 * Created by cbyamba on 2014-01-15.
 */
public class DigitCancelingFractions extends AbstractEulerSolver {

    public static void main(String... euler) {
        Printer.print(new DigitCancelingFractions().solve().toString());
    }


    @Override
    public String doSolve() {
        Fraction fraction = Stream.of(createFractions()).filter(w -> w != null)
                .filter(w -> w.getX() % 10 != 0 && w.getY() % 10 != 0)
                .filter(w -> isCurious(w)).filter(w -> w.getX() != 0).reduce(Fraction.ONE, (w1, w2) -> w1.multiply(w2));
        return "" + reduceFraction(fraction).getY();
    }

    public boolean isCurious(Fraction fraction) {
        String[] digitsX = intToStringArray(fraction.getX());
        String[] digitsY = intToStringArray(fraction.getY());
        if (digitsX[0].equals(digitsY[0])) {
            return ((double) fraction.getX() / fraction.getY()) == ((double) Double.valueOf(digitsX[1]) / Double.valueOf(digitsY[1]));
        }
        if (digitsX[0].equals(digitsY[1])) {
            return ((double) fraction.getX() / fraction.getY()) == ((double) Double.valueOf(digitsX[1]) / Double.valueOf(digitsY[0]));
        }
        if (digitsX[1].equals(digitsY[0])) {
            return ((double) fraction.getX() / fraction.getY()) == ((double) Double.valueOf(digitsX[0]) / Double.valueOf(digitsY[1]));
        }
        if (digitsX[1].equals(digitsY[1])) {
            return ((double) fraction.getX() / fraction.getY()) == ((double) Double.valueOf(digitsX[0]) / Double.valueOf(digitsY[0]));
        }
        return false;
    }


    public Fraction reduceFraction(Fraction fraction) {
        int gcd = gcd(fraction.getX(), fraction.getY());
        return new Fraction(fraction.getX() / gcd,
                fraction.getY() / gcd);
    }

    /**
     * @return
     */
    private Fraction[] createFractions() {
        Collection<Fraction> fractions = new ArrayList<>();
        for (int x = 10; x <= 99; x++) {
            for (int y = 10; y < x; y++) {
                fractions.add(new Fraction(y, x));
            }
        }
        Fraction[] result = fractions.toArray(new Fraction[fractions.size()]);
        return result;
    }
}
