package com.yambacode.solutions.euler62;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by cbyamba on 2014-02-14.
 */
public class CubicPermutations extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        Map<BigInteger, List<Cube>> cubes = LongStream
                .rangeClosed(1, 9_000L)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .map(Cube::new)
                .collect(groupingBy(Cube::getPermutationId));

        Cube minCube = cubes.values()
                .stream()
                .filter(list -> list.size() == 5)
                .map(list -> list
                        .stream()
                        .sorted((cube1, cube2) -> cube1.getValue().compareTo(cube2.getValue()))
                        .collect(Collectors.toList()))
                .map(list -> list.get(0))
                .reduce((cube, min) -> (cube.getValue().compareTo(min.getValue()) < 0) ? cube : min)
                .get();

        return minCube.getValue().toString();
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new CubicPermutations());
    }
}
