package com.yambacode.solutions.euler58;

import com.yambacode.common.io.Printer;
import com.yambacode.math.Primes;

import static org.junit.Assert.assertEquals;

import com.yambacode.solutions.euler54.poker.Tuple;
import org.junit.Test;

import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.ONE;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-03-06.
 */
public class PrimeSpiralBigIntegerTest {

    private static final int SIZE = 20000;

    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger THREE = BigInteger.valueOf(3);
    private static final BigInteger FOUR = BigInteger.valueOf(4);

    PrimeSpiralBigInteger euler = new PrimeSpiralBigInteger();

    @Test
    public void testSpiralDiagonal() {
        long n = 3;
        Printer.print(euler.spiralDiagonal(BigInteger.ONE).toArray());
        Printer.print(spiralStream(n).toArray());
        Object[] primes = spiralStreamOfPrimes(n).toArray();
        Printer.print(primes);
        BigInteger totalValueCount = euler.totalDiagonalCount(BigInteger.valueOf(n));
        Printer.print(String.format("Number of primes : %s of %s", primes.length, totalValueCount));
        BigFraction percent = BigFraction.bigFraction(BigInteger.valueOf(primes.length), totalValueCount);
        Printer.print(String.format("value : %s .. %s", percent, percent.getValue()));

    }

    /**
     * 17 16 15 14  13
     * 18 5  4  3   12
     * 19 6  1  2   11
     * 20 7  8  9   10
     * 21 22 23 24  25
     */
    @Test
    public void testSpiralDiagonalAgain() {

        assertEquals(1, euler.sw(ZERO).intValue());
        assertEquals(1, euler.nw(ZERO).intValue());
        assertEquals(1, euler.ne(ZERO).intValue());
        assertEquals(1, euler.se(ZERO).intValue());

        assertEquals(7, euler.sw(ONE).intValue());
        assertEquals(5, euler.nw(ONE).intValue());
        assertEquals(3, euler.ne(ONE).intValue());
        assertEquals(9, euler.se(ONE).intValue());

        assertEquals(21, euler.sw(TWO).intValue());
        assertEquals(17, euler.nw(TWO).intValue());
        assertEquals(13, euler.ne(TWO).intValue());
        assertEquals(25, euler.se(TWO).intValue());
    }


    @Test
    public void testPrimeCount() {
        assertEquals(0, euler.primeCount(0));
        assertEquals(3, euler.primeCount(1));
        assertEquals(2, euler.primeCount(2));
    }

    /**
     * 0,3,5,8
     */
    @Test
    public void testAccumulatedPrimeCount() {
        //test prerequisite
        testPrimeCount();
        long[] counts = LongStream.range(0, 4)
                .map(x -> euler.primeCount(x))
                .toArray();

        assertEquals(0, euler.accumulateCounts(counts)[0]);
        assertEquals(3, euler.accumulateCounts(counts)[1]);
        assertEquals(5, euler.accumulateCounts(counts)[2]);
        assertEquals(8, euler.accumulateCounts(counts)[3]);
    }

    /**
     *
     */
    @Test
    public void testBigFractionValues() {
        assertTrue(BigFraction.bigFraction(1, 1).equals(BigFraction.bigFraction(ONE, ONE)));
        assertEquals(BigFraction.bigFraction(2, 3), BigFraction.bigFraction(2, 3).reduce());
        assertEquals(BigFraction.bigFraction(2, 3), BigFraction.bigFraction(4, 6).reduce());
        assertEquals(BigFraction.bigFraction(1, 4), BigFraction.bigFraction(25, 100).reduce());

        Printer.print(BigFraction.bigFraction(8, 13).getValue().toString());

        BigInteger diagonalThree = euler.totalDiagonalCount(THREE);
        long accuCount = euler.accumulateCounts(LongStream.range(0, 4).map(n -> euler.primeCount(n)).toArray())[3];
        BigInteger count = BigInteger.valueOf(accuCount);
        BigFraction diagonalPrimeFractionThree = BigFraction.bigFraction(count, diagonalThree);
        Printer.print(diagonalPrimeFractionThree.getValue().toString());
        assertEquals(BigFraction.bigFraction(8, 13).getValue(), diagonalPrimeFractionThree.getValue());
    }

    @Test
    public void testSolution() {
        Optional<Tuple<Integer, BigDecimal>> first = euler.accumulatedCountsAsTuples(LongStream.range(0, SIZE)
                .parallel()
                .map(n -> euler.primeCount(n))
                .toArray())
                .parallelStream()
                .map(tuple -> {
                    BigInteger accumulatedCount = BigInteger.valueOf(tuple._2());
                    BigInteger m = BigInteger.valueOf(tuple._1());
                    BigInteger diagonalCount = euler.totalDiagonalCount(m);
                    return Tuple.tuple(tuple._1(), BigFraction
                            .bigFraction(accumulatedCount, diagonalCount)
                            .getValue());

                })
                .skip(10000)
                .filter(tuple -> tuple._2().compareTo(new BigDecimal("0.1000000000")) < 0)
                .findFirst();

        Integer firstSpiralN = first.get()._1();
        //return euler.oddNumber(BigInteger.valueOf(firstSpiralN)).toString();
    }

    /**
     * 4n+1
     * 1,5,9,13,17,21,25,...
     */
    @Test
    public void testDiagonalCount() {
        assertEquals(1, euler.totalDiagonalCount(ZERO).intValue());
        assertEquals(5, euler.totalDiagonalCount(ONE).intValue());
        assertEquals(9, euler.totalDiagonalCount(TWO).intValue());
        assertEquals(13, euler.totalDiagonalCount(THREE).intValue());
        assertEquals(17, euler.totalDiagonalCount(FOUR).intValue());

    }

    protected Stream<BigInteger> spiralStream(long n) {
        return bigIntegerStream(n).flatMap(k -> euler.spiralDiagonal(k));
    }

    protected Stream<BigInteger> spiralStreamOfPrimes(long n) {
        return Primes.filterPrimes(bigIntegerStream(n).flatMap(k -> euler.spiralDiagonal(k)));
    }

    protected Stream<BigInteger> bigIntegerStream(long n) {
        return LongStream.rangeClosed(1, n).mapToObj(x -> BigInteger.valueOf(x));
    }


}
