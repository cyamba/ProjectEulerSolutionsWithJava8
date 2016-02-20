package com.yambacode.math.combinatorics;

import org.junit.Test;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.yambacode.math.combinatorics.Combinatorics.*;
import static com.yambacode.math.combinatorics.Sets.subsetsFixedSize;

/**
 * Created by cbyamba on 2014-02-08.
 */
public class SetsTest {


    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionWhenNullArgs() {
        Sets.subsets(null);
    }

    @Test
    public void shouldReturnEmptyListWhenArgsListIsEmpty() {
        assertTrue(Sets.subsets(new ArrayList<>()).isEmpty());
    }

    @Test
    public void shouldReturnASetOfSize16WhenArgumentListIs4() {
        Set<TreeSet<Integer>> subsets = Sets.subsets(Arrays.asList(1, 2, 3, 4));
        assertEquals(16, subsets.size());
    }

    @Test
    public void shouldReturnACorrectSetOfSubSets() {
        Set<TreeSet<Integer>> subsets = Sets.subsets(Arrays.asList(1, 2, 3));
        assertTrue(subsets.contains(treeSet()));
        assertTrue(subsets.contains(treeSet(1)));
        assertTrue(subsets.contains(treeSet(2)));
        assertTrue(subsets.contains(treeSet(3)));
        assertTrue(subsets.contains(treeSet(1, 2)));
        assertTrue(subsets.contains(treeSet(1, 3)));
        assertTrue(subsets.contains(treeSet(2, 3)));
        assertTrue(subsets.contains(treeSet(1,2,3)));

        assertFalse(subsets.contains(treeSet(0)));
        assertFalse(subsets.contains(treeSet(5)));
    }

    @Test
    public void shouldReturnSubSetsOfFixedSize(){
        Set<TreeSet<Integer>> subsets = Sets.subsetsFixedSize(Arrays.asList(1, 2, 3, 4, 5), 3);
        assertTrue(subsets.stream().allMatch(set -> set.size() == 3));
    }

    @Test
    public void shouldReturnASetOfLength10WhenCalledWith5Over3SizedArgs(){
        Set<TreeSet<Integer>> subsets = Sets.subsetsFixedSize(Arrays.asList(1, 2, 3, 4, 5), 3);
        assertEquals(10,subsets.size());
    }


    private TreeSet<Integer> treeSet(int... ints) {
        TreeSet<Integer> set = new TreeSet<>();
        IntStream.range(0, ints.length).forEachOrdered(
                i -> set.add(ints[i])
        );
        return set;
    }


    @Test
    public void shouldReturnASetOfSubSets() {

    }

    /**
     * (k,n)
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

    }


}
