package com.yambacode.solutions.euler58;

import com.yambacode.common.io.Printer;
import com.yambacode.math.Primes;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;
import com.yambacode.solutions.euler54.poker.Tuple;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-03-06.
 */
public class PrimeSpiralBigInteger extends AbstractEulerSolver {

    public static final int SIZE = 20000;

    @Override
    public String doSolve() {
        Optional<Tuple<Integer, BigDecimal>> first = accumulatedCountsAsTuples(LongStream.range(0, SIZE)
                .parallel()
                .map(n -> this.primeCount(n))
                .toArray())
                .parallelStream()
                .map(tuple -> {
                    BigInteger accumulatedCount = BigInteger.valueOf(tuple._2());
                    BigInteger m = BigInteger.valueOf(tuple._1());
                    BigInteger diagonalCount = totalDiagonalCount(m);
                    return Tuple.tuple(tuple._1(), BigFraction
                            .bigFraction(accumulatedCount, diagonalCount)
                            .getValue());

                })
                .skip(SIZE / 2)
                .filter(tuple -> tuple._2().compareTo(new BigDecimal("0.1000000000")) < 0)
                .findFirst();
        Integer firstSpiralN = first.get()._1();
        return this.oddNumber(BigInteger.valueOf(firstSpiralN)).toString();
    }

    protected long[] accumulateCounts(long[] counts) {
        System.out.println("hello");
        long[] accu = new long[counts.length];
        for (int i = 0; i < counts.length; i++) {
            accu[i] += counts[i];
        }
        Printer.print(accu);
        return accu;
    }

    protected List<Tuple<Integer, Long>> accumulatedCountsAsTuples(long[] counts) {
        long sum = 0;
        List<Tuple<Integer, Long>> accu = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            sum += counts[i];
            accu.add(Tuple.tuple(i, sum));
        }
        return accu;
    }

    protected long primeCount(long n) {
        return Primes.filterPrimes(spiralDiagonal(BigInteger.valueOf(n))).count();
    }


    protected Stream spiralDiagonal(BigInteger n) {
        return Stream.of(nw(n), ne(n), se(n), sw(n));
    }

    /**
     * length is 2n+1
     * total is (2n+1)^2
     *
     * @param primeCount
     * @param n
     * @return
     */
    protected BigDecimal percentOfPrimes(BigInteger primeCount, BigInteger n) {
        BigDecimal pCount = new BigDecimal(primeCount);
        BigDecimal total = new BigDecimal(total(n));
        return pCount.divide(total);
    }

    protected BigInteger total(BigInteger n) {
        return BigInteger.valueOf(2).multiply(n).add(BigInteger.ONE).pow(2);
    }

    /**
     * @param n
     * @return
     */
    protected BigInteger nw(BigInteger n) {
        return BigInteger.valueOf(4).multiply(n.pow(2)).add(BigInteger.ONE);
    }

    /**
     * 4 * n * n - 2 * n + 1;
     *
     * @param n
     * @return
     */
    protected BigInteger ne(BigInteger n) {
        return BigInteger.valueOf(4)
                .multiply(n.pow(2))
                .subtract(BigInteger.valueOf(2)
                        .multiply(n))
                .add(BigInteger.ONE);
    }

    /**
     * can be excluded. never prime
     *
     * @param n
     * @return
     */
    protected BigInteger se(BigInteger n) {
        return total(n);
    }

    /**
     * 4 * n * n + 2 * n + 1
     *
     * @param n
     * @return
     */
    protected BigInteger sw(BigInteger n) {
        return BigInteger.valueOf(4).multiply(n.pow(2)).add(oddNumber(n));
    }

    /**
     * 2*n+1
     */
    protected BigInteger oddNumber(BigInteger n) {
        return BigInteger.valueOf(2).multiply(n).add(BigInteger.ONE);
    }

    /**
     * 4*n+1
     *
     * @param n
     * @return
     */
    protected BigInteger totalDiagonalCount(BigInteger n) {
        return BigInteger.valueOf(4).multiply(n).add(BigInteger.ONE);
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new PrimeSpiralBigInteger());
    }


}
