package com.seewhy.solutions.euler51;

import com.seewhy.common.io.Printer;
import com.seewhy.math.Primes;
import com.seewhy.math.Sets;
import com.seewhy.solutions.AbstractEulerSolver;

import static com.seewhy.solutions.EulerRunner.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

import static com.seewhy.common.util.DigitTransformations.replaceDigitsWith0To9;

/**
 * Created by cbyamba on 2014-02-20.
 */
public class PDRSimple extends AbstractEulerSolver {

    public List<List<Integer>> transformNumbersToFamiliesOverSubSetsAndNumber(Set<TreeSet<Integer>> subsets, Integer originalNumber) {
        return subsets.parallelStream()
                .filter(set -> !set.isEmpty())
                .map(set -> replaceDigitsWith0To9(originalNumber,
                        set.stream()
                                .mapToInt(x -> x)
                                .toArray())
                        .stream()
                        .mapToInt(x -> x)
                        .boxed()
                        .collect(toList()))
                .collect(toList());
    }

    @Override
    public String doSolve() {
        Optional<List<Integer>> result = IntStream.range(100_000, 400_000)
                .parallel()
                .boxed()
                .flatMap(x -> transformNumbersToFamiliesOverSubSetsAndNumber(Sets
                        .subsets(IntStream
                                .rangeClosed(0, ("" + x).length() - 1)
                                .boxed().collect(toList())), x)
                        .stream()
                        .parallel())
                .filter(list -> list.size() == 8)
                .distinct()
                .findFirst();

        return result.get().get(0).toString();
    }

    public static void main(String... args) {
        Printer.print("Grab a cop of coffee, this might take a while depending on the number of cores I have at my disposal...");
        runEulerSolvers(new PDRSimple());
    }

}
