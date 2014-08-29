package com.yambacode.solutions.euler61;

import com.yambacode.common.collections.Lists;
import com.yambacode.common.collections.Streams;
import com.yambacode.common.io.Printer;
import com.yambacode.math.Numbers;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.yambacode.math.Numbers.*;

/**
 * Created by cbyamba on 2014-04-12.
 */
public class Euler61 extends AbstractEulerSolver {

    public static final int MAX_INCLUSIVE = 100000;
    public static final int CYCLE_LENGTH = 4;

    @Override
    public String doSolve() {

        List<FigurativeNumber> figurativeNumbers = getFigurativeNumbers();

        Map<String, List<FigurativeNumber>> firstTwoMap = figurativeNumbers.stream().filter(fig -> fig.getFirstTwo() != null).collect(Collectors.groupingBy(fig -> fig.getFirstTwo()));
        Map<String, List<FigurativeNumber>> lastTwoMap = figurativeNumbers.stream().filter(fig -> fig.getFirstTwo() != null).collect(Collectors.groupingBy(fig -> fig.getLastTwo()));

        List<FigurativeNumber> filteredFigs = figurativeNumbers.stream().filter(fig -> fig.getFirstTwo() != null).filter(fig -> firstTwoMap.containsKey(fig.getLastTwo())).collect(Collectors.toList());
        Printer.print(filteredFigs.toArray());
        Map<Object, List<FigurativeNumber>> firstTwoFilteredMap = filteredFigs.stream().filter(fig -> fig.getFirstTwo() != null).collect(Collectors.groupingBy(fig -> fig.getFirstTwo()));

        int startPosition = 0;
        List<Cycle> cycles = getCycles(filteredFigs, startPosition, Lists.of(Cycle.of()));
        Printer.print(cycles.toArray());

        List<Cycle> cyclesOfLength4 = cycles.stream().filter(cycle -> cycle.size() == 4).collect(Collectors.toList());
        Printer.print(cyclesOfLength4.toArray());

        //Optional<Cycle> result = cyclesOfLength4.stream().filter(this::isCyclicalFigurativeNumbers).findFirst();

        //return filteredFigs.stream().map(x -> x.toString()).collect(Collectors.joining("\n"));
        return cyclesOfLength4.toString();
    }

    //OBS one figurative number can have many types!
    //TODO bitwise function mapping for predicates with multivariable booleans
    //10001->five boolean functions on or off. true ~ on
    protected boolean isCyclicalFigurativeNumbers(Cycle cycle) {
        return
                isDistinct(cycle)
                        && isOrderN(cycle)
                        &&
                        isDistinctFigurativeTypes(cycle);
    }

    protected boolean isDistinct(Cycle cycle) {
        long distinctCount = cycle.getCycle().stream().map(fig -> fig.getValue()).distinct().count();
        return cycle.getCycle().size() == distinctCount;
    }

    protected boolean isOrderN(Cycle cycle) {
        return order(cycle) == CYCLE_LENGTH;
    }

    protected boolean isDistinctFigurativeTypes(Cycle cycle) {
        return Lists.isDistinct(
                cycle.getCycle().stream()
                        .map(fig -> fig.getType()
                                .getType())
                        .collect(Collectors.toList())
        );
    }

    protected int order(Cycle cycle) {
        return order0(cycle, cycle.getLast(), 1);
    }

    protected int order0(Cycle cycle, FigurativeNumber number, int order) {
        Optional<FigurativeNumber> nextNumber = Lists.findFirst(cycle.getCycle(), fig -> fig.getFirstTwo().equals(number.getLastTwo()));
        if (!nextNumber.isPresent()) {
            return order;
        }
        if (order == cycle.size() + 1) {
            return --order;
        }
        return order0(cycle, nextNumber.get(), ++order);
    }

    public List<FigurativeNumber> getFigurativeNumbers() {
        return Streams.of((Stream<FigurativeNumber>) nGonalNumberIntegerStream(1, MAX_INCLUSIVE, x -> triangularNumber(x))
                .map(x -> FigurativeNumber.of(x, FigurativeType.TRIANGLE)),
                (Stream<FigurativeNumber>) nGonalNumberIntegerStream(1, MAX_INCLUSIVE, x -> squareNumber(x))
                        .filter(x -> x.toString().length() == 4).map(x -> FigurativeNumber.of(x, FigurativeType.SQUARE)),
                (Stream<FigurativeNumber>) nGonalNumberIntegerStream(1, MAX_INCLUSIVE, x -> pentagonalNumber(x))
                        .filter(x -> x.toString().length() == 4).map(x -> FigurativeNumber.of(x, FigurativeType.PENTAGONAL)),
                (Stream<FigurativeNumber>) nGonalNumberIntegerStream(1, MAX_INCLUSIVE, x -> hexagonalNumber(x))
                        .filter(x -> x.toString().length() == 4).map(x -> FigurativeNumber.of(x, FigurativeType.HEXAGONAL)),
                (Stream<FigurativeNumber>) nGonalNumberIntegerStream(1, MAX_INCLUSIVE, x -> heptagonalNumber(x))
                        .filter(x -> x.toString().length() == 4).map(x -> FigurativeNumber.of(x, FigurativeType.HEPTAGONAL)),
                (Stream<FigurativeNumber>) nGonalNumberIntegerStream(1, MAX_INCLUSIVE, x -> octagonalNumber(x))
                        .filter(x -> x.toString().length() == 4).map(x -> FigurativeNumber.of(x, FigurativeType.OCTAGONAL))
        ).collect(Collectors.toList());
    }

    protected static List<Cycle> getCycles(List<FigurativeNumber> figList, int currentPos, List<Cycle> accumulation) {

        Optional<FigurativeNumber> current = currentPos >= figList.size() ?
                Optional.empty()
                : Optional.of(figList.get(currentPos));

        if (!current.isPresent()) {
            return accumulation;
        }
        Cycle cycle = getCycles0(figList, Cycle.of(current.get()));

        return getCycles(figList, ++currentPos, Lists.<Cycle>of(cycle, accumulation));
    }

    protected static Cycle getCycles0(List<FigurativeNumber> numbers, Cycle cycle) {
        //TODO fix this
        Optional<FigurativeNumber> head = Streams.head(numbers.stream());
        if (!head.isPresent()) {
            return cycle;
        }
        if (cycle.size() == CYCLE_LENGTH - 1) {
            return arrangeLastPieceOfThePuzzle(cycle, head.get());
        }
        if (cycle.size() < CYCLE_LENGTH - 1) {
            FigurativeNumber number = head.get();
            if (cycle.getLast().getLastTwo().equals(number.getFirstTwo())) {
                cycle.add(number);
            }
        }
        return getCycles0(Lists.tail(numbers), cycle);

    }

    /**
     * Given
     * [8128, 2839, 3940, ?] the last piece is at ?
     * This amounts to finding a figurative number that begins this the last two digits of
     * the third entry and ends with the first two digits of the first entry
     * i.e. (3940, 8128) gives 4081
     *
     * @param cycle
     * @return
     */
    protected static Cycle arrangeLastPieceOfThePuzzle(Cycle cycle, FigurativeNumber number) {
        FigurativeNumber lastPiece = cycle.getLast();
        boolean isNGonalNumber = Numbers.isNGonalNumber(lastPiece, FigurativeType.values());
        if (isNGonalNumber) {
            cycle.add(number);
        }
        Printer.print("found last piece");
        return cycle;
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new Euler61());
    }
}
