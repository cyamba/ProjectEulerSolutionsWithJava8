package com.seewhy.solutions.euler67;

import com.seewhy.common.io.Java8Reader;
import com.seewhy.solutions.AbstractEulerSolver;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-04-22.
 */
public class MaximumPathSumII extends AbstractEulerSolver {

    public static final String PATH = "/Users/cbyamba/programming/github/RECENT/ProjectEulerSolutionsWithJava8/src/main/java/com/seewhy/solutions/euler67/triangle.txt";

    @Override
    public String doSolve() {
        List<int[]> triangularGrid = Java8Reader.reader(PATH).lines()
                .map(line -> line.split(" "))
                .map(s -> Stream.of(s)
                        .mapToInt(x -> Integer.valueOf(x)).toArray())
                .collect(Collectors.toList());
        return null;
    }
}
