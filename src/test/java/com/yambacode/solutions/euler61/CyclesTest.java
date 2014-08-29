package com.yambacode.solutions.euler61;

import com.yambacode.common.collections.Lists;
import com.yambacode.common.io.Printer;
import com.yambacode.math.Numbers;
import com.yambacode.solutions.euler61.fresh.CFN;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-04-15.
 */
public class CyclesTest {

    private Euler61 unitUnderTest = new Euler61();

    private CycleAPI api = new CycleAPI();

    @Test
    public void testCycleValidation() {
        Cycle cycle = api.getCycle(FigurativeNumber.of(1225, Numbers.FigurativeType.SQUARE));

    }

    @Test
    public void testCycleGeneration() {
        CFN euler = new CFN();
        Cycle cycle = Cycle.of();
        Cycle add = cycle.add(FigurativeNumber.of(1035))
                .add(FigurativeNumber.of(3544))
                .add(FigurativeNumber.of(4497));

        Printer.print(" Test ");
        Printer.print(add.toString());

        Printer.print(add.add(FigurativeNumber.of(9710)).toString());
        /**

         */
        Euler61 euler61 = new Euler61();

        List<FigurativeNumber> figurativeNumbers = euler61.getFigurativeNumbers();
        Map<String, List<FigurativeNumber>> firstTwoMap = figurativeNumbers.stream()
                .filter(n -> n.getValue().toString().length() == 4)
                .collect(Collectors.groupingBy(x -> x.getFirstTwo()));
        List<FigurativeNumber> result = figurativeNumbers.stream().filter(n -> n.getValue().toString().length() == 4)
                .filter(n -> firstTwoMap.containsKey(n.getLastTwo())).collect(Collectors.toList());

        //List<Cycle> collect = result.stream().flatMap(x -> generateCycles(x, result)).collect(Collectors.toList());
        //Printer.print(collect.toArray());
    }


    @Test
    public void testNew() {

        Printer.print("New iterative approach");

        Euler61 euler61 = new Euler61();

        List<FigurativeNumber> figurativeNumbers = euler61.getFigurativeNumbers();

        Map<String, List<FigurativeNumber>> firstTwoMap = figurativeNumbers.stream()
                .filter(n -> n.getValue().toString().length() == 4)
                .collect(Collectors.groupingBy(x -> x.getFirstTwo()));

        List<FigurativeNumber> result = figurativeNumbers.stream().filter(n -> n.getValue().toString().length() == 4)
                .filter(n -> firstTwoMap.containsKey(n.getLastTwo())).collect(Collectors.toList());

        List<Cycle> one = createOne(result);

        List<Cycle> two = createN(one, result, Optional.empty());

        List<Cycle> three = createN(two, result, Optional.empty());
        Printer.print(three.toArray());

        List<Cycle> four = createN(three, result, Optional.<Predicate<Cycle>>of(cycle -> cycle.isCycle()));

        Printer.print("four cycles : ");

        Printer.print(four.toArray());
    }

    private List<Cycle> createN(List<Cycle> one, List<FigurativeNumber> result, Optional<Predicate<Cycle>> predicateOptional) {

        return one.stream()
                .flatMap(o -> result.stream()
                        .map(n -> o.add(n)))
                .filter(predicateOptional.isPresent() ? predicateOptional.get() : x -> true)
                .collect(Collectors.toList());
    }

    private List<Cycle> createOne(List<FigurativeNumber> result) {
        return result.stream().map(n -> Cycle.of().add(n)).collect(Collectors.toList());
    }

    public Stream<Cycle> generateCycles(List<FigurativeNumber> numberList) {
        List<Cycle> cycles = Lists.newArrayList();
        for (int i1 = 3; i1 < numberList.size(); i1++) {
            for (int i2 = 2; i2 < i1; i2++) {
                for (int i3 = 1; i3 < i2; i3++) {
                    for (int i4 = 0; i4 < i3; i4++) {
                        cycles.add(Cycle.of(
                                numberList.get(i1),
                                numberList.get(i2),
                                numberList.get(i3),
                                numberList.get(i4)
                        ));
                    }
                }
            }
        }
        return cycles.stream().filter(c -> c.isCycle());
    }

}
