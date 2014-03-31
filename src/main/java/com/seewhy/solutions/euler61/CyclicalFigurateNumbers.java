package com.seewhy.solutions.euler61;

import static com.seewhy.math.Numbers.*;

import com.seewhy.solutions.AbstractEulerSolver;
import com.seewhy.solutions.EulerRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by cbyamba on 2014-02-10.
 */
public class CyclicalFigurateNumbers extends AbstractEulerSolver {

    public static final int START = 1000;
    public static final int END = 9999;
    public static final java.util.function.Predicate<? super Integer> PREDICATE = x -> x >= START && x < END;


    @Override
    public String doSolve() {

        Map<String, List<FigurativeNumber>> collect = triangularNumbersLessThan(1, 3 * END)
                .stream().filter(PREDICATE)
                .map(x -> new FigurativeNumber(x))
                .collect(Collectors.groupingBy(FigurativeNumber::getFirstTwo));

        /**
         * start with triangular
         * take lastTo
         * see if squares contain lastTwo
         * if not take next triangular
         * repeat.
         * if lastTwo is contained in lastTwo
         * add two cycle.
         * if use square take last two repeat.
         * if cycle
         * check if count of cycle is six.
         * if no take next triangular and repeat
         * else return cycle
         */
        return Arrays.toString(collect.entrySet().toArray());
    }


    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new CyclicalFigurateNumbers());
    }
}
