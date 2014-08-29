package com.yambacode.solutions.euler39;

import static com.yambacode.math.Divisibility.*;

import com.yambacode.solutions.AbstractEulerSolver;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingByConcurrent;
import static java.util.stream.Stream.of;

/**
 * Created by cbyamba on 2014-01-29.
 */
public class IntegerRightTriangles extends AbstractEulerSolver {

    private static final int MAX = 1000;

    public Triple[] generateTriples() {
        Triple[] triples = new Triple[100 * MAX * MAX];
        int i = 0;
        //TODO  lambdaify
        for (int m = 1; m <= MAX; m++) {
            for (int n = 1; m > n && isCoprime(m, n); n++) {
                for (int k = 1; 2 * k * m * n <= MAX; k++) {
                    triples[i++] = new Triple(
                            k * (m * m - n * n),
                            k * (2 * m * n),
                            k * (m * m + n * n)
                    );
                }
            }
        }
        return of(triples)
                .filter(t -> t != null && t.getPerimeter() > 0 && t.getPerimeter() <= MAX)
                .distinct()
                .toArray(Triple[]::new);
    }

    @Override
    public String doSolve() {
        Map<Integer, List<Triple>> tripleAccumulation = of(generateTriples())
                .collect(groupingByConcurrent(Triple::getPerimeter));

        Object[] triples = tripleAccumulation.values().stream()
                .reduce((a1, a2) -> (a1.size() > a2.size()) ? a1 : a2).get()
                .toArray();

        return ((Triple) of(triples).findFirst().get()).getPerimeter().toString();
    }

}
