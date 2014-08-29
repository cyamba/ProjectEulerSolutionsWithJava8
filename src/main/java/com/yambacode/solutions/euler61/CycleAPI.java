package com.yambacode.solutions.euler61;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by cbyamba on 2014-04-15.
 */
public class CycleAPI {

    private Euler61 euler61 = new Euler61();

    private List<FigurativeNumber> numbersCache;
    private Map<String, List<FigurativeNumber>> numbersByFirstTwo;

    public Cycle getCycle(FigurativeNumber number) {
        loadCache();
        Cycle cycle = Cycle.of(number);
        if (cycle.size() == Euler61.CYCLE_LENGTH) {
            return cycle;
        }
        if (cycle.size() == 0) {
            cycle.add(number);
        }
        String lastTwo = cycle.getLast().getLastTwo();
        List<FigurativeNumber> numbersWithSameFirstTwo = numbersByFirstTwo.get(lastTwo);

        return cycle;
    }

    public void loadCache() {
        if (numbersCache == null) {
            numbersCache = euler61.getFigurativeNumbers();
            numbersByFirstTwo = numbersCache.stream().collect(Collectors.groupingBy(fig -> fig.getFirstTwo()));
        }
    }
}
