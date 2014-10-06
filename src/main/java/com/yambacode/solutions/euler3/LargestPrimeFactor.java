package com.yambacode.solutions.euler3;


import com.yambacode.common.io.Printer;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.util.function.LongPredicate;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * TODO fix java.lang.OutOfMemoryError: Java heap space
 * work with Streams...
 * Created by cbyamba on 2014-01-09.
 */
public class LargestPrimeFactor extends AbstractEulerSolver {

    private static long INPUT_VALUE = 600851475143l;
    //private static long INPUT_VALUE = 13195l;


    /**
     * "Eratosthenes Sieve"
     *
     * @param numbers
     * @param primes
     * @param predicate
     * @param composite
     * @return
     */
    public long[] primeSieve(long[] numbers, long[] primes, LongPredicate predicate, long composite) {

        long lastPrime = primes[primes.length - 1];
        if (lastPrime >= Math.sqrt(composite)) {
            return primes;
        }
        long[] newNumbers = sieve(numbers, predicate);
        if (newNumbers.length == 0) {
            return primes;
        }
        long newPrime = newNumbers[0];
        long[] newPrimes = newPrimeArray(primes, newPrime);
        return primeSieve(newNumbers, newPrimes, x -> x % newPrime != 0, composite);
    }

    private long[] newPrimeArray(long[] primes, long newPrime) {
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

    /**
     * TODO refactor to lambda
     *
     * @param primes
     * @param number
     * @return
     */
    public long getLargestPrimeFactor(long[] primes, long number) {
        for (int i = primes.length - 1; i > 0; i--) {
            if (number % primes[i] == 0) {
                return primes[i];
            }
        }
        return -1;
    }

    @Override
    public String doSolve() {
        //600851475143
        long[] numbers = LongStream.range(2, INPUT_VALUE).toArray();
        long[] primes = primeSieve(numbers, new long[]{2}, x -> x % 2 != 0, INPUT_VALUE);
        return String.valueOf(getLargestPrimeFactor(primes, INPUT_VALUE));
    }

    public static void main(String... args) {
        throw new UnsupportedOperationException("TODO fixmeifyoucan!");
    }


}
