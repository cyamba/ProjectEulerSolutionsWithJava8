package com.yambacode.math;

import java.util.List;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by cbyamba on 2014-03-18.
 */
public class EquivalenceRelations {

    public static <T, U> Map<U, List<T>> partition(Collection<T> collection, Function<T, U> function) {
        return collection.parallelStream()
                .collect(Collectors.groupingBy(function::apply));
    }
}
