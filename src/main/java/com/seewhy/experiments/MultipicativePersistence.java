package com.seewhy.experiments;

import static com.seewhy.math.Numbers.multiplicativePersistence;
import static com.seewhy.math.Numbers.lowestMultiplicativePersistenceRoot;

import com.seewhy.solutions.AbstractEulerSolver;
import com.seewhy.solutions.EulerRunner;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-03-12.
 */
public class MultipicativePersistence extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        Object[] result = IntStream.range(50, 100)
                .parallel()
                .boxed()
                .map(x -> multiplicativePersistence(x))
                .toArray();

        Object[] result999 = IntStream.of(99, 999, 9999, 99999, 999999, 9999999)
                .parallel()
                .boxed()
                .map(x -> multiplicativePersistence(x))
                .toArray();

        Object[] resultRoots = IntStream.of(2, 3, 4, 5, 6)
                .parallel()
                .map(x -> lowestMultiplicativePersistenceRoot(x))
                .boxed()
                .toArray();

        return Arrays.deepToString(result) + "\n\t\t"
                + Arrays.deepToString(result999) + "\n\t\t"
                + Arrays.deepToString(resultRoots);
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new MultipicativePersistence());
    }
}
