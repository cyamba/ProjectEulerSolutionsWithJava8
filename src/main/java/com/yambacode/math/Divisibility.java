package com.yambacode.math;


import com.yambacode.common.io.Printer;
import com.yambacode.solutions.euler54.poker.Tuple;
import com.yambacode.solutions.euler65.Fraction;
import com.yambacode.solutions.euler70.Fractions;
import com.yambacode.solutions.euler97.BigIntegers;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;

/**
 * Created by cbyamba on 2014-01-10.
 */
public class Divisibility {

    /**
     * 2011-11-12
     * @param number
     * @return
     */
    public static int numberOfDivisors(BigInteger number) {
        BigInteger divisor = BigInteger.ONE;
        int count = 1;
        while (divisor.compareTo(number) < 0) {
            if (number.mod(divisor).equals(BigInteger.ZERO)) {
                count++;
            }
            //TODO find optimizing criteras for which to return
            divisor = divisor.add(BigInteger.ONE);
        }
        return count;
    }

    public static long totient(long n) {
        return LongStream.range(1, n).filter(k -> isCoprime(n, k)).count();
    }

    public static long totient2(long n) {
        if (n % 4 == 0) {
            return 2 * totient(n / 2);
        }
        if (BigInteger.valueOf(n).isProbablePrime(10)) {
            return n - 1;
        }
        return totient3(n);
    }

    public static long totient3(long number) {
        List<Long> primeFactors = primeFactors(number);
        double a = primeFactors.parallelStream().mapToDouble(p -> 1d - (1d / p.doubleValue()))
                .reduce((x, accu) -> accu * x).orElse(0);
        double b = (double) number;
        double c = a * b;
        return (long) c;
    }

    /**
     * @param number
     * @return
     */
    public static List<Tuple<Long, Integer>> primeFactorsMultiplicity(final long number) {
        return Primes.generatePrimesAsList(((long) ceil((sqrt(number)))))
                .stream()
                .map(p -> Tuple.of(p, multiplicity(p, number, 0)))
                .collect(Collectors.toList());
    }

    public static List<Long> primeFactors(long number) {
        return Primes.generatePrimesAsList(number)
                .stream()
                .filter(x -> Primes.isPrime(x) && number % x == 0)
                .collect(Collectors.toList());
    }

    private static int multiplicity(long p, long n, int k) {
        if (n % p != 0) {
            return k;
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
        if ((Primes.isPrime(a) | Primes.isPrime(b)) && a != b) {
            return 1;
        }
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

    public static Fraction totient(List<BigInteger> primes) {
        BigInteger n = BigIntegers.multiply(primes.toArray(new BigInteger[primes.size()]));
        Printer.print("n = " + n);
        Fraction[] fractions = primes.stream().map(p -> primeFraction(p)).toArray(i -> new Fraction[primes.size()]);
        Printer.print(fractions);
        Fraction product = Fractions.multiply(fractions);
        Printer.print(product.toString());
        return Fraction.of(n).multiply(product);
    }

    public static Fraction primeFraction(BigInteger prime) {
        return Fractions.ONE.subtract(Fraction.of(1, prime.longValue()));
    }

    public static int[] properDivisors(int n) {
        return IntStream.range(1, n).filter(x -> n % x == 0).toArray();
    }

    public static List<Integer> properDivisorsList(int n) {
        return IntStream.range(1, n).filter(x -> n % x == 0).boxed().collect(Collectors.toList());
    }

    public static int sumOfProperDivisors(int n) {
        return IntStream.of(properDivisors(n)).sum();
    }

    public static Result numberOfPrimeFactors(int m, List<Long> p) {
        List<Long> primes = p;
        Set<Long> divisors = new HashSet<Long>();
        Integer first = m;
        for (Long i : primes) {
            while (m % i == 0) {
                m /= i;
                divisors.add(i);
            }
            if (i >= m) {
                break;
            }
        }
        return ResultBuilder.create()
                .first(first)
                .count(divisors.size())
                .build();
    }
}
