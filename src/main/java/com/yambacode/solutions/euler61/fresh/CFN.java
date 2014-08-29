package com.yambacode.solutions.euler61.fresh;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;
import com.yambacode.solutions.euler61.Euler61;
import com.yambacode.solutions.euler61.FigurativeNumber;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-04-18.
 */
public class CFN extends AbstractEulerSolver {

    private Euler61 euler61 = new Euler61();

    private List<FigurativeNumber> figurativeNumbers = euler61.getFigurativeNumbers().stream()
            .filter(x -> x.toString().length() == 4)
            .collect(Collectors.toList());

    private Map<String, List<FigurativeNumber>> continuationMap = figurativeNumbers.stream().collect(Collectors.groupingBy(x -> x.getFirstTwo()));

    private Map<String, List<FigurativeNumber>> predecessorMap = figurativeNumbers.stream().collect(Collectors.groupingBy(x -> x.getLastTwo()));


    @Override
    public String doSolve() {
        find6Cycle(figurativeNumbers.stream()
                .filter(x -> hasContinuation(x))
                .filter(x -> hasPredecessor(x)));

        return figurativeNumbers.stream()
                .filter(x -> hasContinuation(x))
                .filter(x -> hasPredecessor(x))
                .map(x -> x.toStringInfo())
                .collect(Collectors.joining());
    }

    public List<FigurativeNumber> find6Cycle(Stream<FigurativeNumber> numbers) {
        FigurativeNumber _6CycleNumber = numbers.filter(n -> has6Cycle(n)).findFirst().get();
        return get6Cycle(_6CycleNumber);
    }

    public boolean has6Cycle(FigurativeNumber number) {
        //return continuationMap.get(number).stream().map(hasNCycle(number, 5, new ArrayList<>()));
        return false;
    }

    public Predicate<? super FigurativeNumber> hasNCycle(FigurativeNumber number, int n, List<FigurativeNumber> accu) {
        return null;
    }


    public List<FigurativeNumber> get6Cycle(FigurativeNumber cycleNumber) {
        return null;
    }

    public List<FigurativeNumber> get6Cycle0(List<FigurativeNumber> accu, int count) {
        if (count == 6) {
            return accu;
        }
        return null;
    }

    public boolean hasPredecessor(FigurativeNumber number) {
        return predecessorMap.containsKey(number.getFirstTwo());
    }

    public boolean hasContinuation(FigurativeNumber number) {
        return continuationMap.containsKey(number.getLastTwo());
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new CFN());
    }
}
