package com.yambacode.solutions.euler60;

import com.yambacode.math.Primes;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;
import com.yambacode.solutions.euler54.poker.Tuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-03-09.
 */
public class PrimePairSetNewTake extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        List<List<Tuple<Long, Long>>> collect = Primes.generatePrimesAsList(8000)
                .parallelStream()
                .map(this::amicablePrimeParts)
                .filter(list -> list.size() > 0)
                .collect(Collectors.toList());
        return Arrays.deepToString(collect.toArray());
    }

    protected List<Long> collectPrimeFamily(Integer number, List<Tuple> flattenedTuples) {
        return null;
    }

    protected List<Tuple<Long, Long>> amicablePrimeParts(Long number) {
        String numberStr = number.toString();
        if (numberStr.length() < 2) {
            return new ArrayList<>();
        }
        return IntStream.rangeClosed(0, numberStr.length() - 2)
                .mapToObj(
                        x -> Tuple.tuple(numberStr.substring(0, x + 1), numberStr.substring(x + 1)))
                .map(stringTuple -> Tuple.tuple(Long.valueOf(stringTuple._1()), Long.valueOf(stringTuple._2())))
                .filter(numberTuple ->
                        Primes.arePrimes(
                                numberTuple._1(),
                                numberTuple._2(),
                                Long.valueOf(numberTuple._2() + "" + numberTuple._1())//concatenate primes reversed order
                        )
                )
                .collect(Collectors.toList());
    }


    //TODO reduction by equivalence relation -> BiPredicate<T> (x,y)->f(x)==f(y);
    //TODO distict method for list of lists. equal lists
    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new PrimePairSetNewTake());
    }
}
