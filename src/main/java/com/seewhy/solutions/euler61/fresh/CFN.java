package com.seewhy.solutions.euler61.fresh;

import com.seewhy.solutions.AbstractEulerSolver;
import com.seewhy.solutions.EulerRunner;
import com.seewhy.solutions.euler61.Cycle;
import com.seewhy.solutions.euler61.CyclicalFigurateNumbers;
import com.seewhy.solutions.euler61.Euler61;
import com.seewhy.solutions.euler61.FigurativeNumber;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by cbyamba on 2014-04-18.
 */
public class CFN extends AbstractEulerSolver {

    private Euler61 euler61 = new Euler61();

    private List<FigurativeNumber> figurativeNumbers = euler61.getFigurativeNumbers().stream()
            .filter(x -> x.toString().length() == 4)
            .collect(Collectors.toList());

    private Map<String, List<FigurativeNumber>> continuationMap = figurativeNumbers.stream().collect(Collectors.groupingBy(x -> x.getFirstTwo()));

    @Override
    public String doSolve() {
        return figurativeNumbers.stream()
                .filter(x -> hasContinuation(x))
                .map(x -> x.toStringInfo())
                .collect(Collectors.joining());
    }

    public boolean hasContinuation(FigurativeNumber number) {
        return continuationMap.containsKey(number.getLastTwo());
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new CFN());
    }
}
