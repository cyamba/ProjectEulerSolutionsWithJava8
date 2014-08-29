package com.yambacode.experiments;

import com.yambacode.common.util.NumberStringConversions;
import com.yambacode.math.Permutations;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-03-08.
 */
public class MathProblem88 extends AbstractEulerSolver {
    @Override
    public String doSolve() {
        Long[] set = LongStream.rangeClosed(1, 9).boxed().toArray(x -> new Long[9]);
        Collection<Comparable[]> permutations = Permutations.generatePermutationCollection(set);
        Object[] objects = permutations.parallelStream().filter(this::isSquare)
                .map(NumberStringConversions::comparableArrayToLong)
                .toArray();
        return Arrays.deepToString(objects);
    }

    public boolean isSquare(Comparable[] comparable) {
        long[] digits = Stream.of(comparable).mapToLong(x -> (Long) x).toArray();
        long number = NumberStringConversions.longArrayToLong(digits);
        return (long) Math.sqrt(number) * (long) Math.sqrt(number) == number;
    }

    public static void main(String[] args) {
        EulerRunner.runEulerSolvers(new MathProblem88());
    }

}
