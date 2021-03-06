package com.yambacode.common.collections;

import static com.yambacode.solutions.euler54.poker.Tuple.tuple;

import com.yambacode.solutions.euler54.poker.Tuple;

import java.util.List;

import java.util.ArrayList;

import static java.util.stream.Collectors.toList;

import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-03-01.
 */
public class Tuples {

    public static <T, U> List<Tuple<T, U>> zip(Tuple<List<T>, List<U>> tupleOfLists) {
        return zip(tupleOfLists._1(), tupleOfLists._2());
    }

    public static <T, U> List<Tuple<T, U>> zip(List<T> firstList, List<U> secondList) {
        List<Tuple<T, U>> list = new ArrayList<>();
        IntStream
                .range(0, firstList.size())
                .forEachOrdered(i -> list.add(tuple(firstList.get(i), secondList.get(i))));
        return list;
    }

    public static <T, U> List<Tuple<T, U>> zip(T[] firstObjects, U[] secondObjects) {
        List<Tuple<T, U>> list = new ArrayList<>();
        IntStream
                .range(0, firstObjects.length)
                .forEachOrdered(i -> list.add(tuple(firstObjects[i], secondObjects[i])));
        return list;
    }

    public static <T, U> Tuple<List<T>, List<U>> unzip(List<Tuple<T, U>> listOfTuples) {
        List<T> firstList = listOfTuples.parallelStream().map(tuple -> tuple._1()).collect(toList());
        List<U> secondList = listOfTuples.parallelStream().map(tuple -> tuple._2()).collect(toList());
        return tuple(firstList, secondList);
    }


}
