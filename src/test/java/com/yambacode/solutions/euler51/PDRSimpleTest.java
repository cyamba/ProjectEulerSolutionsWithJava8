package com.yambacode.solutions.euler51;

import com.yambacode.common.io.Printer;
import com.yambacode.math.combinatorics.Sets;
import org.junit.Test;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-02-20.
 */
public class PDRSimpleTest {

    @Test
    public void testTransform() {
        PDRSimple euler = new PDRSimple();

        //List<List<Integer>> lists = euler.transformNumbersToFamiliesOverSubSetsAndNumber(Sets.subsets(Arrays.asList(0, 1, 2)), 12343);
        List<List<Integer>> result = IntStream.range(1000, 100000)
                .boxed()
                .flatMap(x -> euler.transformNumbersToFamiliesOverSubSetsAndNumber(Sets
                        .subsets(IntStream.rangeClosed(0, ("" + x).length()-1).boxed().collect(Collectors.toList())), x).stream())
                .collect(Collectors.toList());


      //  String s = Arrays.toString(lists.toArray());
      //  Printer.print(s);
        String resultStr = Arrays.toString(result.toArray());
        Printer.print(resultStr);
    }
}
