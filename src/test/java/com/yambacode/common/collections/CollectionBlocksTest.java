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
    public void testToBlockStream() {
        List<Integer> list = IntStream.range(0, 100).boxed().collect(Collectors.toList());
        List<List<Integer>> lists = CollectionBlocks.toBlockList(list, 5);
        Printer.print(lists.toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenBlockListSizeIsLessThanBlockSize() {
        List<Integer> list = IntStream.range(0, 2).boxed().collect(Collectors.toList());
        CollectionBlocks.toBlockList(list, 5);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionWhenListArgumentIsNull() {
        CollectionBlocks.toBlockList(null, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentWhenBlockSizeDoesNotDivideListSize() {
        List<Integer> list = IntStream.range(0, 9).boxed().collect(Collectors.toList());
        CollectionBlocks.toBlockList(list, 7);
    }
}
