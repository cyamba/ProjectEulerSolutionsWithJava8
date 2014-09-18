package com.yambacode.solutions.euler8;

import com.yambacode.math.Products;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

/**
 * Created by cbyamba on 2011
 */
public class PythagoreanTriplesByIntegerPartitions extends AbstractEulerSolver {

    public Number compute() {
        for (int i = 1; i < 1000; i++)
            for (int j = 1; j < 1000; j++)
                for (int k = 1; k < 1000; k++)
                    if (PythagoreanTriples.isPythagoreanTriple(i, j, k))
                        return Products.productOf(i, j, k);
        return -1;
    }

    private static int triples[] = {998, 1, 1};

    public static Number test() {
        while (triples[0] > triples[1]) {
            triples[0]--;
            triples[1]++;
            if (PythagoreanTriples.isPythagoreanTriple(triples))
                return Products.productOf(triples);
            while (triples[1] > triples[2]) {
                triples[1]--;
                triples[2]++;
                if (PythagoreanTriples.isPythagoreanTriple(triples))
                    return Products.productOf(triples);
            }
        }
        return -1;
    }

    public static void main(String... a) {
        EulerRunner.runEulerSolvers(new PythagoreanTriplesByIntegerPartitions());
    }

    @Override
    public String doSolve() {
        return compute().toString();
    }
}
