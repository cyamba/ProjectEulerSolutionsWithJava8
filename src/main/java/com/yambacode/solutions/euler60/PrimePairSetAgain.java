package com.yambacode.solutions.euler60;

import com.yambacode.math.Primes;
import com.yambacode.math.combinatorics.Sets;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-03-08.
 */
public class PrimePairSetAgain extends AbstractEulerSolver {

    protected List<Long> primes = Primes.generatePrimesAsList(10000);

    @Override
    public String doSolve() {
        return "" + subsets5(IntStream.range(0, primes.size())
                .boxed().collect(Collectors.toList()))
                .stream()
                .mapToLong(x -> x)
                .sum();
    }

    public List<Long> subsets5(List<Integer> originalSet) {
        for (int i1 = 4; i1 < originalSet.size(); i1++) {
            for (int i2 = 3; i2 < i1; i2++) {
                for (int i3 = 2; i3 < i2; i3++) {
                    for (int i4 = 1; i4 < i3; i4++) {
                        for (int i5 = 0; i5 < i4; i5++) {
                            List<Long> primeList = check(i1, i2, i3, i4, i5);
                            if (primeList != null) {
                                return primeList;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    protected List<Long> check(int i1, int i2, int i3, int i4, int i5) {
        List<Long> subList = Arrays.asList(primes.get(i1), primes.get(i2), primes.get(i3), primes.get(i4), primes.get(i5));
        List<TreeSet<Integer>> twoSets = Sets.subsets(Arrays.asList(0, 1, 2, 3, 4)).stream()
                .filter(set -> set.size() == 2)
                .collect(Collectors.toList());
        return twoSets.parallelStream().allMatch(set -> check(set, subList)) ? subList : null;
    }

    protected boolean check(TreeSet<Integer> set, List<Long> subList) {
        Integer[] pair = set.toArray(new Integer[2]);
        Long prime1 = concatenate(pair[0], pair[1], subList);
        Long prime2 = concatenate(pair[1], pair[0], subList);
        return Primes.arePrimes(prime1, prime2);
    }

    protected Long concatenate(Integer first, Integer second, List<Long> subList) {
        return Long.valueOf(subList.get(first).toString() + subList.get(second).toString());
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new PrimePairSetAgain());
    }
}
