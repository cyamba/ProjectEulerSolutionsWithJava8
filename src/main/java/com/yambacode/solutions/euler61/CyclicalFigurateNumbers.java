package com.yambacode.solutions.euler61;

import static com.yambacode.math.FigurativeNumbers.*;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-02-10.
 */
public class CyclicalFigurateNumbers extends AbstractEulerSolver {

    public static final int START = 1000;
    public static final int END = 9999;
    public static final java.util.function.Predicate<? super Integer> PREDICATE = x -> x >= START && x < END;


    @Override
    public String doSolve() {

        List<Integer> triangulars = triangularNumbersLessThan(1, 3 * END);
      //  Map<String, List<FigurativeNumber>> collect = triangulars
      //          .stream().filter(PREDICATE)
                //.map(x -> FigurativeNumber.of(x))
                //.collect(Collectors.groupingBy(FigurativeNumber::getFirstTwo));

        //Cycle result = algorithm(triangulars.stream()
        //        .map(FigurativeNumber::of), Cycle.of(FigurativeNumber.of(triangulars.get(0))));
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
        //return "" + result.getCycle().stream()
        //        .mapToLong(figNumber -> (long) figNumber.getValue()).sum();
        return "";
    }


    public Cycle algorithm(Stream<FigurativeNumber> numberStream, Cycle accu) {
        if (accu.isCycle()) { //TODO add more to termination criteria (length of cycle == 6)
            return accu;
        }
        FigurativeNumber nextNumber = null;
        while ((nextNumber = findNextNumber(numberStream, accu.getLast())) == null) {
            FigurativeType type = numberStream.findFirst().get().getType().next();
            if (type == FigurativeType.UNDEFINED) {
                break;
            }
           // numberStream = Numbers.figurativeNumbers(type, 3 * END).stream()
           //         .filter(PREDICATE).map(FigurativeNumber::of);
        }
        if (nextNumber == null) {
            return null;
        }
        return algorithm(numberStream, accu.add(nextNumber));
    }

    private FigurativeNumber findNextNumber(Stream<FigurativeNumber> numberStream, FigurativeNumber last) {
        return null;
    }


    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new CyclicalFigurateNumbers());
    }
}
