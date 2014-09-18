package com.yambacode.solutions.euler61.newtry;

import static com.yambacode.math.FigurativeNumbers.figurativeNumbers;
import static com.yambacode.math.FigurativeNumbers.nGonalNumbers;

import com.yambacode.common.io.Printer;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.groupingBy;

import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-09-11.
 */
public class NewAttempt extends AbstractEulerSolver {

    private static final int START = 1000;
    private static final int END = 10000;


    /**
     * Generate all four digit  triangle, square, … , octagonal numbers
     * Start with any number as the beginning of the chain
     * Given the chain current find a number that
     * is cyclic as described
     * is not a type of number which is already used in the chain
     * is different from other numbers in the chain
     * If the chain is of length 6 check that it can be closed – if true then finish
     * If such a number exists add it to the chain and go to 3
     * If no such number exists remove the last number from the chain and go to 3.
     *
     * @return
     */
    @Override
    public String doSolve() {
        //generate all figurative numbers from type 3..8
        List<FigurativeNumber> numbers = figurativeNumbers(START, END, 3, 4, 5, 6, 7, 8);
        //group figurative numbers by las first in order to filter those with more than 0 continuations
        Map<String, List<FigurativeNumber>> groupedByFirstTwo = numbers.stream().collect(groupingBy(x ->
                        (x.getValue() + "").substring(0, 2))
        );
        Printer.print(groupedByFirstTwo.entrySet().toArray());

        //filter non-zero continuations
        List<FigurativeNumber> filteredNumbers = numbers.stream()
                .filter(x -> {
                    String lastTwo = (x.getValue() + "").substring(2, 4);
                    List<FigurativeNumber> values = groupedByFirstTwo.get(lastTwo);
                    return values != null && values.size() > 0;
                })
                .collect(toList());
        Printer.print(filteredNumbers.toArray());

        Map<FigurativeNumber, List<FigurativeNumber>> dictionary = new HashMap<>();
        for (FigurativeNumber number : filteredNumbers) {
            List<FigurativeNumber> continuation = groupedByFirstTwo.get((number.getValue() + "").substring(2, 4));
            dictionary.put(number, continuation.stream().filter(f -> f.getType() != number.getType()).collect(toList()));
        }
        Printer.print(dictionary.entrySet().toArray());

        return null;
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new NewAttempt());

        Printer.print(BigInteger.valueOf(2).pow(64).toString());
    }
}
