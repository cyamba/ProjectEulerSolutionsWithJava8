package com.yambacode.experiments;

import com.yambacode.common.collections.Arrays2D;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.util.List;
import java.util.stream.IntStream;

import static com.yambacode.math.combinatorics.Permutations.generatePermutationCollection;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * Created by cbyamba on 2014-03-12.
 */
public class NonAttackingQueens extends AbstractEulerSolver {

    private static final int n = 8;

    protected boolean isNonAttackingQueensBoard(int[][] board) {
        return checkAllSubDiagonals(board);
    }

    protected boolean checkAllSubDiagonals(int[][] board) {
        return Arrays2D.getAllSubDiagonalsAsList(board)
                .stream()
                .allMatch(array -> IntStream.of(array).sum() <= 1);
    }

    @Override
    public String doSolve() {
        Integer[] original = IntStream
                .range(0, n)
                .boxed()
                .toArray(x -> new Integer[n]);

        List<int[][]> nonAttackingSolutions = generatePermutationCollection(original)
                .parallelStream()
                .map(Arrays2D::fromPermutation)
                .filter(this::isNonAttackingQueensBoard)
                .collect(toList());

        String result = nonAttackingSolutions
                .stream()
                .map(Arrays2D::deepToString)
                .collect(joining("\n\n"));

        return "\n" + result + "\n\n"
                + nonAttackingSolutions.size() + " solutions";
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new NonAttackingQueens());
    }

}
