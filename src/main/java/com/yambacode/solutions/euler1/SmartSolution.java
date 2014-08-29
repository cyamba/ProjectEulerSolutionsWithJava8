package com.yambacode.solutions.euler1;

import com.yambacode.common.io.Printer;
import com.yambacode.solutions.AbstractEulerSolver;

/**
 * Created by cbyamba on 2014-02-10.
 */
public class SmartSolution extends AbstractEulerSolver {

    /**
     * Simple reduction to sum of a arithmetical sequence. 1+2+3+...+n = n*(n+1)/2   (K.F. Gauss)
     * #{A U B} = #A + #B - #{A and B}
     * Answer : 3*(1+2+3+...+333) + 5*(1+2+3+...+199) -15*(1+2+3...+66) = 3*(333*334/2)+5*(199*200/2)-15*(66*67/2)
     *
     * @return
     */
    @Override
    public String doSolve() {
        //return "" + (3 * (333 * 334 / 2) + 5 * (199 * 200 / 2) - 15 * (66 * 67 / 2));
        return "" + generalizedForm(MultiplesOf3And5.SIZE);
    }

    public static long generalizedForm(long max) {
        max -= 1;
        long factorA = (max / 3) * ((max / 3) + 1) / 2;
        long factorB = (max / 5) * ((max / 5) + 1) / 2;
        long factorC = (max / 15) * ((max / 15) + 1) / 2;
        return (3 * factorA + 5 * factorB - 15 * factorC);
    }

    public static void main(String... args) {
        Printer.print(new SmartSolution().solve().toString());
    }
}
