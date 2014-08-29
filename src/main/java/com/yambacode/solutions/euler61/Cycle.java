package com.yambacode.solutions.euler61;

import com.yambacode.common.collections.Lists;
import com.yambacode.common.io.Printer;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-03-31.
 */
public class Cycle {

    private List<FigurativeNumber> cycle = Lists.newArrayList();

    private String firstTwoOfFist;

    private Optional<Boolean> isCycle = Optional.empty();

    private Cycle(List<FigurativeNumber> cycle) {
        if (!Objects.isNull(cycle) && !cycle.isEmpty()) {
            this.cycle = cycle;
        }
    }

    private Cycle() {
    }

    public static Cycle of(FigurativeNumber... numbers) {
        Cycle newCycle = new Cycle();
        IntStream.range(0, numbers.length).forEach(
                x -> newCycle.add(numbers[x])
        );
        return newCycle;
    }

    /**
     * Add number according to rules. first two of new number should match last two of last number
     * if cycle is a cycle don't add new number
     *
     * @param number
     * @return
     */
    public Cycle add(FigurativeNumber number) {
       // Printer.print("attempt : " + number + " first two " + firstTwoOfFist);
        if (isCycle.isPresent()) {
            if (isCycle.get()) {
        //        Printer.print("Nothing added. Cycle is already a cycle");
                return this;
            }
        }
        //TODO containsElementWith(Predicate<E>)
        if (firstTwoOfFist != null && number.getLastTwo().equals(firstTwoOfFist)) {
            cycle.add(number);
            isCycle = Optional.of(true);
            Printer.print("added last peace of the puzzle. isCycle!");
            return this;
        }
        if (firstTwoOfFist == null) {
          //  Printer.print("first entry");
            cycle.add(number);
            firstTwoOfFist = number.getFirstTwo();
            return this;
        }
        if (firstTwoOfFist != null) {
            FigurativeNumber lastNumber = getLast();
            if (lastNumber.getLastTwo().equals(number.getFirstTwo())) {
                cycle.add(number);
            //    Printer.print("just another Joe");
            }
            return this;
        }
        return this;
    }

    public FigurativeNumber getLast() {
        return cycle.get(cycle.size() - 1);
    }

    public List<FigurativeNumber> getCycle() {
        return cycle;
    }

    public int size() {
        return cycle.size();
    }

    public Optional<Boolean> getIsCycle() {
        return isCycle;
    }

    public boolean isCycle() {
        return isCycle.isPresent() ? isCycle.get() : false;
    }

    @Override
    public String toString() {
        return "{ " + (isCycle() ? "isCycle " : "") + Arrays.deepToString(cycle.toArray()) + " }";
    }
}
