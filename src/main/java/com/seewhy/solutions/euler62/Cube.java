package com.seewhy.solutions.euler62;

import com.seewhy.common.io.Printer;

import java.math.BigInteger;

import static java.util.Comparator.*;

import java.util.stream.LongStream;

import static com.seewhy.common.util.NumberStringConversions.bigIntegerToPrimitiveLongArray;
import static java.util.stream.Collectors.joining;

/**
 * Created by cbyamba on 2014-02-14.
 */
public class Cube {

    private final BigInteger permutationId;

    private final BigInteger value;

    private final BigInteger root;

    public Cube(BigInteger root) {
        this.root = root;
        this.value = root.multiply(root).multiply(root);
        this.permutationId = createPermutationId(value);
    }

    protected BigInteger createPermutationId(BigInteger value) {
        long[] digits = bigIntegerToPrimitiveLongArray(value);
        String sortedDigits = LongStream.of(digits).boxed().sorted(reverseOrder()).map(digit -> String.valueOf(digit)).collect(joining());
        return new BigInteger(sortedDigits);
    }

    public BigInteger getPermutationId() {
        return permutationId;
    }

    public BigInteger getValue() {
        return value;
    }

    public BigInteger getRoot() {
        return root;
    }

    @Override
    public String toString() {
        return String.format("%s^3 = %s", root, value.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cube cube = (Cube) o;

        if (permutationId != null ? !permutationId.equals(cube.permutationId) : cube.permutationId != null)
            return false;
        if (root != null ? !root.equals(cube.root) : cube.root != null) return false;
        if (value != null ? !value.equals(cube.value) : cube.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = permutationId != null ? permutationId.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (root != null ? root.hashCode() : 0);
        return result;
    }
}
