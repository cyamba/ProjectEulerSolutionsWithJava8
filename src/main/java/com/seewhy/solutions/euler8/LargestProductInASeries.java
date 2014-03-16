package com.seewhy.solutions.euler8;

import com.seewhy.common.io.Printer;
import com.seewhy.solutions.AbstractEulerSolver;

import java.io.File;

import java.util.Comparator;
import java.util.stream.Stream;

import static com.seewhy.common.io.ContentReader.getContent;
import static com.seewhy.common.util.StringToIntegers.convert;
import static com.seewhy.math.Partitions.toEqualParts;
import static java.util.stream.IntStream.of;
import static java.util.stream.Stream.of;

/**
 * Created by cbyamba on 2014-01-13.
 */
public class LargestProductInASeries extends AbstractEulerSolver {

    private static final String PATH = "/Users/cbyamba/programming/github/EulerSolutionsWithJava8/src/main/java/com/seewhy/solutions/euler8/test.euler";

    @Override
    public String doSolve() {
        String content = getContent(new File(PATH));
        Integer[] numbers = convert(content);
        int[][] partition = toEqualParts(numbers, 5);
        Stream<int[]> partitionStream = of(partition);
        Stream<Integer> result = partitionStream.map(x -> of(x).reduce(1, (a, b) -> a * b));
        return result.sorted(Comparator.<Integer>naturalOrder().reversed()).findFirst().get().toString();

    }

    public static void main(String... args) {
        Printer.print(new LargestProductInASeries().solve());
    }
}
