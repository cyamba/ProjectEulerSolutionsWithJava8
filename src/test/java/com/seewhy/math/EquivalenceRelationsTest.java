package com.seewhy.math;

import com.seewhy.common.io.Printer;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-03-18.
 */
public class EquivalenceRelationsTest {

    @Test
    public void testPartition() {
        List<Integer> collection = IntStream.range(0, 100).boxed().collect(Collectors.toList());
        Map<Integer,List<Integer>> partition = EquivalenceRelations.partition(collection, x -> x % 7);
        Object[] objects = partition.entrySet().toArray();
        Printer.print(objects);
    }
}
