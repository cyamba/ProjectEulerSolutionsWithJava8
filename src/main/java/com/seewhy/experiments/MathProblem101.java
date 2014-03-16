package com.seewhy.experiments;

import static com.seewhy.math.Primes.generatePrimesAsList;
import com.seewhy.math.Primes;
import com.seewhy.solutions.AbstractEulerSolver;

import java.util.Arrays;
import java.util.stream.IntStream;

import static com.seewhy.common.collections.Collections.copiesOf;
import static com.seewhy.solutions.EulerRunner.runEulerSolvers;

/**
 * Created by cbyamba on 2014-03-12.
 */
public class MathProblem101 extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        Object[] objects = generatePrimesAsList(10000)
                .parallelStream()
                .filter(this::isSuperPrime)
                .toArray();
        return Arrays.deepToString(objects);
    }

    protected boolean isSuperPrime(Long prime) {
        String[] strings = copiesOf(prime.toString(), prime.toString().length() - 1);
        int length = strings.length;
        return IntStream.range(0, length)
                .mapToObj(i -> strings[i].substring(0, length - i))
                .map(s -> Long.valueOf(s))
                .allMatch(Primes::isPrime);
    }

    public static void main(String... args) {
        runEulerSolvers(new MathProblem101());
    }
}
