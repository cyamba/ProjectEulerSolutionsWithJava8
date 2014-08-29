package com.yambacode.common.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-03-16.
 */
public class CollectionBlocks {

    public static <T> List<List<T>> toBlockList(List<T> list, int n) {
        List<List<T>> result = new ArrayList<>();
        IntStream.range(0, list.size() / n)
                .map(x -> n * x)
                .limit(list.size() - n)
                .forEachOrdered(i ->
                {
                    List<T> block = new ArrayList<>();
                    IntStream.range(i, i + n).forEachOrdered(k -> {
                        block.add(list.get(k));
                    }
                    );
                    result.add(block);
                }
                );
        return result;
    }
}
