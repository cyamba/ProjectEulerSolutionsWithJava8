package com.seewhy.solutions.euler49;

import com.seewhy.common.util.UpDownCastArrays;

import java.util.Arrays;
import java.util.Collection;

import static com.seewhy.common.util.NumberStringConversions.comparableArrayToLong;
import static com.seewhy.common.util.NumberStringConversions.longArrayToLong;
import static com.seewhy.math.Permutations.generatePermutationCollection;
import static java.util.stream.Collectors.toList;

/**
 * http://projecteuler.net/problem=49
 * <p/>
 * Created by cbyamba on 2014-02-01.
 */
public class PrimePermutation {

    private Collection<Comparable[]> permutations;

    private long[] digits;

    public PrimePermutation(long[] digits) {
        this.digits = digits;
        this.permutations = generatePermutationCollection(UpDownCastArrays.upCast(digits))
                .stream()
                .filter(xs -> isLargerThanDigits(digits, xs))
                .collect(toList());
    }

    protected boolean isLargerThanDigits(long[] digits, Comparable[] xs) {
        return comparableArrayToLong(xs) > longArrayToLong(digits);
    }

    public Collection<Comparable[]> getPermutations() {
        return permutations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrimePermutation that = (PrimePermutation) o;

        if (!permutations.equals(that.permutations)) return false;

        return true;
    }

    public Long getAsLong() {
        return longArrayToLong(digits);
    }

    @Override
    public int hashCode() {
        return permutations.hashCode();
    }

    @Override
    public String toString() {
        return permutations.stream().map(x -> Arrays.toString(x)).reduce("", (s1, s2) -> s1 + 2);
    }
}
