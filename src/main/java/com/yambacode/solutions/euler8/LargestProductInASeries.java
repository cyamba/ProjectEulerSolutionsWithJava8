package com.yambacode.solutions.euler8;

import com.yambacode.common.io.Printer;
import com.yambacode.solutions.AbstractEulerSolver;

import java.io.File;

import java.util.Comparator;
import java.util.stream.Stream;

import static com.yambacode.common.io.ContentReader.getContent;
import static com.yambacode.common.util.StringToIntegers.convert;
import static com.yambacode.math.combinatorics.Partitions.toEqualParts;
import static java.util.stream.IntStream.of;
import static java.util.stream.Stream.of;

/**
 * Created by cbyamba on 2014-01-13.
 */
public class LargestProductInASeries extends AbstractEulerSolver {

    private static final String PATH = "./src/main/java/com/yambacode/solutions/euler8/test.euler";

    @Override
    public String doSolve() {
        Integer[] numbers = convert(getContent(new File(PATH)));
        int[][] partition = toEqualParts(numbers, 5);
        Stream<Integer> result = Stream.of(partition).map(x -> of(x).reduce(1, (a, b) -> a * b));
        return result.sorted(Comparator.<Integer>naturalOrder().reversed()).findFirst().get().toString();

    }

    public static void main(String... args) {
        Printer.print(new LargestProductInASeries().solve());
    }
}
