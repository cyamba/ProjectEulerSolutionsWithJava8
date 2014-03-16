package com.seewhy.math;


import com.seewhy.common.io.Printer;

import java.util.List;

import java.math.BigInteger;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * Created by cbyamba on 2014-01-10.
 */
public class Divisibility {

    public static long totient(long n) {
        return LongStream.range(1, n).filter(k -> isCoprime(n, k)).count();
    }

    public static Map<Long, Integer> primeFactors(long n) {
        //Primes.generatePrimesAsList(n).stream().collect(Collectors.groupingBy((Long p) -> p, p -> multiplicity(p, n, 1)));
        return null;
    }

    private static int multiplicity(long p, int n, int k) {
        if (n % p != 0) {
            return --k;
        }
        return multiplicity(p * p, n, ++k);
    }

    public static long totientFTA(long n) {
        List<Long> longs = LongStream
                .concat(LongStream.of(1), fundamentalTheoremOfArithmetic(n)
                        .stream()
                        .mapToLong(x -> x))
                .boxed()
                .collect(Collectors.toList());

        // Printer.print(longs.toArray());
        return longs
                .stream()
                .map(p -> p - 1)
                .reduce(1l, (a, b) -> a * b);

    }

    public static long[] totients(long endInclusive) {
        return LongStream.rangeClosed(1, endInclusive).map(Divisibility::totientFTA).toArray();
    }

    public static List<Long> fundamentalTheoremOfArithmetic(long n) {
        return Primes
                .generatePrimesAsList(n)
                .stream()
                .filter(p -> n % p == 0)
                .collect(Collectors.toList());
    }

    public static long[] totients(int startInclusive, int endInclusive) {
        return LongStream.rangeClosed(startInclusive, endInclusive).map(Divisibility::totient).toArray();
    }

    /**
     * TODO improve given a list of primes. generate a sufficiently large enough list or primes to check divisibility.
     *
     * @param number
     * @return
     */
    public static boolean isComposite(long number) {
        if (number < 4) {
            return false;
        }
        long i = 4;
        while (i < number) {
            if (number % i == 0) {
                return true;
            }
        }
        return false;
    }

    public static BigInteger gcd(BigInteger n, BigInteger m) {
        return null;//TODO
    }

    public static BigInteger gcd(BigInteger... numbers) {
        return null;//TODO
    }

    /**
     * Assumes n > k
     *
     * @param n
     * @param k
     * @return
     */
    public static long gcd(long n, long k) {
        if (k == 0) {
            return n;
        }
        return gcd(k, n % k);
    }

    /**
     * Assumes a > b
     *
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static BigInteger gcdBetter(BigInteger a, BigInteger b) {
        return a.gcd(b);
    }

    public static boolean isCoprime(int m, int n) {
        return gcd(m, n) == 1;

    }

    public static boolean isCoprime(long m, long n) {
        return gcd(m, n) == 1;
    }


    public static void main(String... args) {
        int a = gcd(25, 625);
        Printer.print(a);
        Printer.print(totientFTA(7));
        Printer.print(fundamentalTheoremOfArithmetic(10).toArray());
        double p = 7;
        p = p - 1d;
        Printer.print("======");
        Printer.print(totients(10));
    }
}
