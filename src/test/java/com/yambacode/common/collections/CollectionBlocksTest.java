package com.yambacode.common.collections;

import com.yambacode.common.io.Printer;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-03-16.
 */
public class CollectionBlocksTest {


    @Test
    public void testToBlockStream(){
        List<Integer> collect = IntStream.range(0, 100).boxed().collect(Collectors.toList());
        List<List<Integer>> lists = CollectionBlocks.toBlockList(collect, 5);
        Printer.print(lists.toArray());
    }
}
