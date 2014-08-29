package com.yambacode.solutions.euler60;

import com.yambacode.math.Primes;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;
import com.yambacode.solutions.euler54.poker.Tuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-03-09.
 */
public class PrimePairSetNewIdea extends AbstractEulerSolver {


    public static final int FAMILY_SIZE = 3;

    protected boolean arePrimeConcatenatable(Long member, Long candidate) {
        return Primes.arePrimes(concatenate(member, candidate),
                concatenate(candidate, member));
    }

    protected Long concatenate(Long member, Long candidate) {
        return Long.valueOf(member.toString() + candidate.toString());
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new PrimePairSetNewIdea());
    }

    protected List<List<Long>> createFamilies(List<List<Long>> accu, List<Long> primes) {
        if (accu.stream().anyMatch(list -> list.size() == FAMILY_SIZE)) {
            return accu;
        }
        List<List<Long>> newAccu = accu.stream()
                .flatMap(family -> expandFamilies(family, primes).stream()).collect(toList());
        return createFamilies(newAccu, primes);
    }

    protected List<List<Long>> expandFamilies(List<Long> family, List<Long> primes) {
        return primes.stream()
                .map(p -> createFamily(p, family))
                .collect(toList());
    }

    private List<Long> createFamily(Long prime, List<Long> family) {
        if (family.stream().allMatch(member -> arePrimeConcatenatable(member, prime))) {
            family.add(prime);
        }
        return family;
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
                .collect(toList());
    }


    @Override
    public String doSolve() {
        List<Long> primes = Primes.generatePrimesAsList(10000);
        List<Long> familyCandidates = primes
                .stream()
                .map(this::amicablePrimeParts)
                .filter(list -> list.size() > 0)
                .flatMap(list -> flatten(list).stream())
                .distinct()
                .collect(toList());
        List<List<Long>> initialAccu = familyCandidates.stream().map(member -> {
            List<Long> family = new ArrayList<>();
            family.add(member);
            return family;
        }).collect(toList());
        List<List<Long>> result = createFamilies(initialAccu, primes);

        return Arrays.deepToString(result.toArray());
    }

    private List<Long> flatten(List<Tuple<Long, Long>> list) {
        return list.stream()
                .flatMap(tuple -> {
                    List<Long> xs = new ArrayList<>();
                    xs.add(tuple._1());
                    xs.add(tuple._2());
                    return xs.stream();
                })
                .collect(toList());
    }
}
