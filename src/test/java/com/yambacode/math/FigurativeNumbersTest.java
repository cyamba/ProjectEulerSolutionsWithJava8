package com.yambacode.math;

import static junit.framework.Assert.*;

import com.yambacode.common.io.Printer;
import com.yambacode.solutions.euler54.poker.Tuple;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.Arrays.*;

import static com.yambacode.math.FigurativeNumbers.*;

/**
 * Created by cbyamba on 2014-02-13.
 */
public class FigurativeNumbersTest {

    public static final int START = 1000;
    public static final int END = 10000;

    /**
     * Triangle
     * n(n+1)/2
     * 1, 3, 6, 10, 15, ...
     */
    @Test
    public void testTriangleNumbers() {
        assertEquals(1, triangularNumber(1));
        assertEquals(3, triangularNumber(2));
        assertEquals(6, triangularNumber(3));
        assertEquals(10, triangularNumber(4));
        assertEquals(15, triangularNumber(5));
        //assertEquals(asList(1, 3, 6, 10, 15), triangularNumbersLessThan(1, 15));
        assertEquals(asList(1, 3, 6, 10, 15), triangleNumbersRangeClosed(1, 5));

        //assertTrue(isTriangularNumber(10));
        //assertTrue(isTriangularNumber(15));

        assertTrue(isTriangleGeneralized(10));
        assertTrue(isTriangleGeneralized(15));

        assertTrue(areTriangleNumbers(1, 3, 6, 10, 15));

        //negative cases
        assertFalse(isTriangleGeneralized(11));
        assertFalse(isTriangleGeneralized(16));
        assertFalse(areTriangleNumbers(1, 2, 6, 15));
    }

    /**
     * Triangle 	  	P3,n=n(n+1)/2 	  	1, 3, 6, 10, 15, ...
     * Square 	  	    P4,n=n2 	  	1, 4, 9, 16, 25, ...
     * Pentagonal 	  	P5,n=n(3n−1)/2 	  	1, 5, 12, 22, 35, ...
     * Hexagonal 	  	P6,n=n(2n−1) 	  	1, 6, 15, 28, 45, ...
     * Heptagonal 	  	P7,n=n(5n−3)/2 	  	1, 7, 18, 34, 55, ...
     * Octagonal 	  	P8,n=n(3n−2) 	  	1, 8, 21, 40, 65, ...
     */
    @Test
    public void testFigurativeNumbers() {
        /*Printer.print(nGonalNumbers(10000, 3).toArray());
        Printer.print(nGonalNumbers(10000, 4).toArray());
        Printer.print(nGonalNumbers(10000, 5).toArray());
        Printer.print(nGonalNumbers(10000, 6).toArray());
        Printer.print(nGonalNumbers(10000, 7).toArray());
        Printer.print(nGonalNumbers(10000, 8).toArray());*/

        Map<Tuple<Integer, Integer>, List<Integer>> connections = new HashMap<>();
        for (int i = 3; i <= 8; i++) {
            for (int j = i + 1; j < 8; j++) {
                connections.putAll(getNGonalNumbers(i, j));
            }
        }
        Printer.print(connections.entrySet().toArray());
    }

    private Map<Tuple<Integer, Integer>, List<Integer>> getNGonalNumbers(int i, int j) {
        Map<Tuple<Integer, Integer>, List<Integer>> connections = new HashMap<>();
        List<Integer> secondList = nGonalNumbers(START, END, j);
        List<Integer> firstList = nGonalNumbers(START, END, i);
        Map<String, List<Integer>> firstTwoOfSecondList = secondList.stream()
                .collect(groupingBy(x -> x.toString().substring(0, 2)));
        for (Integer type : firstList) {
            String key = type.toString().substring(2);
            if (firstTwoOfSecondList.containsKey(key)) {
                connections.put(Tuple.of(i, type), firstTwoOfSecondList.get(key));
            }
        }
        return connections;
    }


    @Test
    public void test() {
        for (int i = 3; i <= 8; i++) {
            
        }
    }

    public Map<String, List<Integer>> groupBy(List<Integer> numbers) {
        Map<String, List<Integer>> collect = numbers.stream().collect(groupingBy(i -> i.toString().substring(0, 2)));
        return collect;
    }

}
