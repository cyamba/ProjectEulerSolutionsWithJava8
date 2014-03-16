package com.seewhy.experiments;

import com.seewhy.common.collections.Arrays2D;
import com.seewhy.common.io.Printer;
import org.junit.Test;

/**
 * Created by cbyamba on 2014-03-14.
 */
public class NonAttackingQueensTest {

    private NonAttackingQueens nonAttackingQueens = new NonAttackingQueens();

    @Test
    public void testMapToBoard() {

        Integer[] permutation = {1, 0, 2, 3};
        int[][] board = Arrays2D.fromPermutation(permutation);
        Printer.print(board);

        board = new int[4][4];
        Printer.print();
        Printer.print(board);


    }

    @Test
    public void test() {
        int[][] board = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        int[][] allSubDiagonalsNWSE = Arrays2D.getAllSubDiagonalsNWSE(board);
        Printer.print("allSubDiagonalsNWSE");
        Printer.print(allSubDiagonalsNWSE);

        int[][] allSubDiagonalsNESW = Arrays2D.getAllSubDiagonalsNESW(board);
        Printer.print("allSubDiagonalsNESW");
        Printer.print(allSubDiagonalsNESW);

        int[][] allSubDiagonals = Arrays2D.getAllSubDiagonals(board);
        Printer.print("allSubDiagonals");
        Printer.print(allSubDiagonals);

        boolean result = nonAttackingQueens.checkAllSubDiagonals(board);
        Printer.print(result);
    }
}
