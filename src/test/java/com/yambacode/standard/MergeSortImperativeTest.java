package com.yambacode.standard;

import com.yambacode.common.io.Printer;
import com.yambacode.standard.mergesort.MergeSortImperative;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-09-17.
 */
public class MergeSortImperativeTest {

    @Test
    public void testMergeSort() {
        int[] numbers = Seed.randomIntegers(4);
        Printer.print(numbers);
        int[] result = MergeSortImperative.mergeSort(numbers);
        Printer.print(result);
    }
}
