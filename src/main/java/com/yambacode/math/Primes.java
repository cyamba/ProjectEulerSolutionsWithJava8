package com.yambacode.math;


import com.yambacode.common.io.Printer;
import com.yambacode.solutions.euler97.BigIntegers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by cbyamba on 2014-01-10.
 */
public class Primes {

    //TODO static{ initiera med massor av primtal}

    public static boolean arePrimes(int... args) {
        return IntStream.of(args).allMatch(Primes::isPrime);
    }

    public static boolean arePrimes(long... args) {
        return LongStream.of(args).allMatch(Primes::isPrime);
    }

    public static Integer nextPrimeDown(int number) {
        int i = number % 2 == 0 ? number - 1 : number;
        while (i >= 5) {
            i -= 2;
            if (isPrime(i)) {
                return i;
            }
        }

        return (i == 3) ? 2 : null;
    }

    public static Long nextPrimeDown(long number) {
        long i = number % 2 == 0 ? number - 1 : number;
        while (i >= 5) {
            i -= 2;
            if (isPrime(i)) {
                return i;
            }
        }
        return (i == 3l) ? 2l : null;
    }

    public static int nextPrimeUp(int number) {
        return -1;
    }


    public static boolean isPrime(long number) {
        if (number < 2) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        int i = 3;
        while (i <= Math.sqrt(number)) {
            if (number % i == 0) {
                return false;
            }

            i += 2;
        }
        return true;
    }

    public LongPredicate isPrime() {
        return x -> isPrime(x);
    }


    private static long[] primes = {2};

    public static long[] generatePrimesClosed(int start, int endInclusive) {
        return generatePrimes(start, endInclusive + 1);
    }

    public static long[] generatePrimes(int start, int end) {
        long[] primes = generatePrimes(end);
        return LongStream.of(primes).filter(x -> x >= start).toArray();
    }

    public static List<Long> generatePrimesAsList(long end) {
        return LongStream.of(generatePrimes(end)).boxed().collect(toList());
    }

    public static int[] generatePrimesNonRecursive(int start, int end) {
        Collection<Integer> primes = new ArrayList<>();
        Integer nextPrime = isPrime(end) ? end : nextPrimeDown(end);
        while (nextPrime > 2 && nextPrime > end) {
            primes.add(nextPrime);
            nextPrime = nextPrimeDown(nextPrime);
        }
        return primes.stream().mapToInt(x -> x).toArray();
    }

    public static int[] generatePrimesNonRecursiveClosed(int start, int endInclusive) {
        return generatePrimesNonRecursive(start, endInclusive + 1);
    }

    public static int[] generatePrimesNonRecursive(int end) {
        Collection<Integer> primes = new ArrayList<>();
        Integer nextPrime = isPrime(end) ? end : nextPrimeDown(end);
        while (nextPrime > 2) {
            primes.add(nextPrime);
            nextPrime = nextPrimeDown(nextPrime);
        }
        return primes.parallelStream().mapToInt(x -> x).toArray();
    }

    public static int[] generatePrimesFast(int end) {
        int nextPrime = 2;
        Collection<Integer> primes = new ArrayList<>();
        while (nextPrime < end) {
            primes.add(nextPrime);
            nextPrime = BigInteger.valueOf(nextPrime).nextProbablePrime().intValue();
        }
        return primes.parallelStream().mapToInt(x -> x).toArray();
    }

    public static long[] generatePrimesByCount(int count) {
        return Arrays.copyOfRange(generatePrimes(count * (int) Math.sqrt(count)), 0, count);
    }

    /**
     * @return
     */
    public static long[] generatePrimes(long maxValue) {
        long[] numbers = LongStream.range(2, maxValue).toArray();
        long[] primes = primeSieve(numbers, new long[]{2}, x -> x % 2 != 0, maxValue);
        return primes;
    }

    private static long[] primeSieve(long[] numbers, long[] primes, LongPredicate predicate, long maxValue) {
        long lastPrime = primes[primes.length - 1];
        if (lastPrime >= maxValue) {
            return primes;
        }
        long[] newNumbers = sieve(numbers, predicate);
        if (newNumbers.length == 0) {
            return primes;
        }
        long newPrime = newNumbers[0];
        long[] newPrimes = newPrimeArray(primes, newPrime);
        return primeSieve(newNumbers, newPrimes, x -> x % newPrime != 0, maxValue);
    }

    private static long[] newPrimeArray(long[] primes, long newPrime) {
        long[] newPrimes = new long[primes.length + 1];
        for (int i = 0; i < primes.length; i++) {
            newPrimes[i] = primes[i];
        }
        newPrimes[newPrimes.length - 1] = newPrime;
        return newPrimes;
    }

    private static long[] sieve(long[] numbers, LongPredicate predicate) {
        return LongStream.of(numbers).filter(predicate).toArray();
    }

    public static BigInteger priorPrime(BigInteger number) {
        return BigIntegers.priorPrime(number);
    }

    public static LongPredicate isPrimeLambda() {
        return x -> x == 2 || x == 3 || (x >= 2 && (x % 2 != 0 && LongStream.of(3, (long) Math.sqrt(x)).noneMatch(a -> x % a == 0)));
    }

    public static LongPredicate isPrimeLambda2() {
        return x -> x == 2 || (x > 2 && LongStream.of(2, (long) (x - 1)).allMatch(a -> x % a != 0));
    }

    public static boolean isPrime(BigInteger number) {
        return number.isProbablePrime(10);
    }

    public static Predicate<? super BigInteger> isPrimePredicate = x -> isPrime(x);

    public static boolean arePrimes(Stream<BigInteger> numberStream) {
        return numberStream.allMatch(isPrimePredicate);
    }

    public static Stream<BigInteger> filterPrimes(Stream<BigInteger> numberStream) {
        return numberStream.filter(isPrimePredicate);
    }

    public static Stream<BigInteger> filterPrimes(List<BigInteger> numbers) {
        return numbers.parallelStream().filter(isPrimePredicate);
    }


    public static void main(String... args) {
        Printer.print("" + isPrimeLambda2().test(85));
        Printer.print(LongStream.range(1, 100)
                .filter(x -> x == 2 || (x >= 2 && (x % 2 != 0 &&
                        LongStream.of(3, (long) Math.ceil(Math.sqrt(x))).allMatch(a -> x % a != 0))))
                .toArray());
    }
}
