package com.yambacode.solutions.euler95;

import com.yambacode.common.collections.Lists;
import com.yambacode.common.io.Printer;
import com.yambacode.math.Primes;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.yambacode.math.Divisibility.properDivisorsList;
import static com.yambacode.math.Divisibility.sumOfProperDivisors;

/**
 * TODO fixme
 * Created by cbyamba on 2014-09-02.
 */
public class AmicableChains extends AbstractEulerSolver {

    public static final int MAX = 1_000_000;

    @Override
    public String doSolve() {
        return IntStream.range(1000, MAX / 10)
                .filter(n -> sumOfProperDivisors(n) < MAX)
                .filter(n -> !Primes.isPrime(n))
                .peek(Printer::print)
                .mapToObj(n -> getAmicableChain(n))
                .reduce((list, longest) -> list.size() > longest.size() ? list : longest)
                .get().stream()
                .min(Comparator.naturalOrder())
                .get()
                .toString();
    }

    public List<Integer> getAmicableChain(int n) {
        return getAmicableChain0(n, Lists.newArrayList());
    }

    public List<Integer> getAmicableChain0(Integer number, List<Integer> amicableChain) {
        if (number > MAX || number <= 1) {
            return Lists.newArrayList();
        }
        if (amicableChain.contains(number)) {
            return amicableChain.stream().filter(n -> n > 1).collect(Collectors.toList());
        }
        return getAmicableChain0(properDivisorsList(number).stream().mapToInt(Integer::valueOf).sum(), Lists.of(number, amicableChain));
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new AmicableChains());
    }
}
