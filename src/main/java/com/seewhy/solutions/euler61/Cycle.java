package com.seewhy.solutions.euler61;

import com.seewhy.common.collections.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by cbyamba on 2014-03-31.
 */
public class Cycle {

    private List<FigurativeNumber> cycle = Lists.newArrayList();

    private boolean isCycle = false;

    private Cycle(List<FigurativeNumber> cycle) {
        if (!Objects.isNull(cycle) && !cycle.isEmpty()) {
            this.cycle = cycle;
        }
    }

    public static Cycle of(FigurativeNumber... numbers) {
        return new Cycle(Lists.newArrayList(numbers));
    }

    public Cycle add(FigurativeNumber number) {
        if (cycle.contains(number)) {
            isCycle = true;
        }
        cycle.add(number);
        return this;
    }

    public FigurativeNumber getLast(){
        return cycle.get(0);
    }

    public List<FigurativeNumber> getCycle() {
        return cycle;
    }

    public boolean isCycle() {
        return isCycle;
    }

    public int size() {
        return cycle.size();
    }

    @Override
    public String toString() {
        return Arrays.deepToString(cycle.toArray());
    }
}
