package com.seewhy.math;

import com.seewhy.common.io.Printer;

import org.junit.Test;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.seewhy.math.Combinatorics.*;
import static com.seewhy.math.Sets.subsetsFixedSize;

/**
 * Created by cbyamba on 2014-02-08.
 */
public class SetsTest {

    /**
     * 1,2  1,3  1,4  1,5
     * 2,3  2,4  2,5
     * 3,4, 3,5
     * 4,5
     */
    @Test
    public void testIndex() {
        List<Integer> originalSet = Arrays.asList(1, 2, 3, 4, 5);
        List<List<Integer>> sets = subsetsFixedSize(originalSet, 2)
                .stream()
                .map(set -> set.stream().collect(Collectors.toList()))
                .collect(Collectors.toList());


        String message = Arrays.toString(sets.toArray());


        //lower = higher-element
        assertEquals(message, diffOfCombinationSumsOverFixK(5, 4, 2).longValue(),
                sets.stream().filter(set -> set.contains(1)).count());

        assertEquals(message, BigInteger.valueOf(4 + 3), diffOfCombinationSumsOverFixK(5, 3, 2));

        assertEquals(message, diffOfCombinationSumsOverFixK(5, 3, 2).longValue(),
                sets.stream().filter(set -> set.contains(1) || set.contains(2)).count());

//        assertEquals(message, sets.stream().filter(set -> set.contains(1)).count(),
//                SetsExperiment.index(sets, originalSet, 1).longValue());
//
//        assertEquals(message, sets.stream().filter(set -> set.contains(1) || set.contains(2)).count(),
//                SetsExperiment.index(sets, originalSet, 2).longValue());
    }

}
