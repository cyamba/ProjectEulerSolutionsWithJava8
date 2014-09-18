package com.yambacode.solutions.euler8;

import com.yambacode.math.Products;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

/**
 * Created by cbyamba on 2014-09-18.
 */
public class PythagoreanTripleAlgorithm extends AbstractEulerSolver {

    int a, b, c;

    /**
     * * a = m^2 - n^2
     * b = m*n
     * c = m^2 + n^2
     * multiple k
     *
     * @return
     */
    @Override
    public String doSolve() {
        for (int k = 1; k < 1000; k++) {
            for (int n = 1; n < 1000; n++) {
                for (int m = 1; m < 1000; m++) {
                    a = PythagoreanTriples.getA(k, m, n);
                    b = PythagoreanTriples.getB(k, m, n);
                    c = PythagoreanTriples.getC(k, m, n);
                    if (a + b + c == 1000 && PythagoreanTriples.isPythagoreanTriple(a, b, c)) {
                        return Products.productOf(a, b, c).toString();
                    }

                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        EulerRunner.runEulerSolvers(new PythagoreanTripleAlgorithm());
    }

}
