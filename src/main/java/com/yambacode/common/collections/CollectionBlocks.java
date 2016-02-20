package com.yambacode.common.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-03-16.
 */
public class CollectionBlocks {

    /**
     * Creates a list of list of equal sizes indexed from 0 to original list size
     *
     * @param list
     * @param blockSize size of each created block (nested list)
     * @param <T>       type of element
     * @return a list of lists of sizes specified by the argument blockSize
     */
    public static <T> List<List<T>> toBlockList(List<T> list, int blockSize) {
        validate(list, blockSize);
        List<List<T>> result = new ArrayList<>();
        IntStream.range(0, list.size() / blockSize)
                .map(x -> blockSize * x)
                .limit(list.size() - blockSize)
                .forEachOrdered(i ->
                        {
                            List<T> block = new ArrayList<>();
                            IntStream.range(i, i + blockSize).forEachOrdered(k -> {
                                        block.add(list.get(k));
                                    }
                            );
                            result.add(block);
                        }
                );
        return result;
    }

    private static <T> void validate(List<T> list, int n) {
        java.util.Objects.requireNonNull(list);
        if (n > list.size()) {
            throw new IllegalArgumentException(String.format("n must be > list.size(). list : %s, n : %s", list, n));
        }
        if (list.size() % n != 0) {
            throw new IllegalArgumentException(String.format("n must divide list.size(). list : %s, n : %s", list, n));

        }
    }
}
