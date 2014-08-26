package com.seewhy.solutions.euler65;

import com.seewhy.solutions.AbstractEulerSolver;
import com.seewhy.solutions.EulerRunner;

import static com.seewhy.solutions.euler65.Fraction.*;

/**
 * Created by cbyamba on 2014-08-23.
 * <p/>
 * <url>http://projecteuler.net/problem=65<url/>
 */
public class ConvergentsOfE extends AbstractEulerSolver {


    private static final int FRACTION_COUNT = 99;

    /**
     * 2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536
     *
     * @return
     */
    @Override
    public String doSolve() {
        return "" + doFractions(FRACTION_COUNT).getNumerator().toString()
                .chars().map(x -> Integer.valueOf(Character.toString((char) x))).sum();
    }

    public Fraction doFractions(int fractionCount) {
        if (fractionCount < 0) {
            throw new IllegalArgumentException("fractionCount must be > 0");
        }
        if (fractionCount == 0) {
            return TWO;
        }
        return TWO.add(doFractions0((fractionCount + 1) % 3 == 0 ?
                Fraction.of(1, 2 * (fractionCount + 1) / 3) : ONE, 0, fractionCount));
    }

    /**
     * e = [2; 1,2,1, 1,4,1, 1,6,1 , ... , 1,2k,1, ...].
     *
     * @param fraction
     * @param count
     * @return
     */
    Fraction doFractions0(Fraction fraction, int count, int size) {
        if (count == size - 1) {
            return fraction;
        }
        if ((size - count) % 3 == 1 || (size - count) % 3 == 2) {
            return doFractions0(ONE.add(fraction).invert(), ++count, size);
        }
        return doFractions0(Fraction.of(2 * ((size - count) / 3))
                .add(fraction).invert(), ++count, size);
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new ConvergentsOfE());
    }
}
