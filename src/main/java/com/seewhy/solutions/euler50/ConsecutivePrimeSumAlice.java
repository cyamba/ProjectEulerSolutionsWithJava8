package com.seewhy.solutions.euler50;

import com.seewhy.common.io.Printer;
import com.seewhy.math.Primes;
import com.seewhy.solutions.AbstractEulerSolver;

import java.util.stream.LongStream;

/**
 * Created by cbyamba on 2014-01-25.
 */
public class ConsecutivePrimeSumAlice extends AbstractEulerSolver {

//    public long getPrimeSum(long max) {
//        return LongStream.of(Primes.generatePrimes(max)).sum();
//    }

    //TODO begin with a prime less than one million then try subtracting consecutive primes with decreasing starting values below it
    //til something clicks

    public boolean isPrimeSummandable(long prime) {
        Printer.print(prime + "");
        Long currentPrime = Primes.nextPrimeDown(prime);
        while (currentPrime != null && currentPrime >= 2) {
            if (isPrimeSummandable(prime, currentPrime)) {
                return true;
            }
            currentPrime = Primes.nextPrimeDown(currentPrime);
        }
        return false;
    }

    private boolean isPrimeSummandable(long sum, Long currentPrime) {
        while (currentPrime != null &&
                sum > 0 && currentPrime >= 2) {
            sum -= currentPrime;
            if (sum < 0) {
                return false;
            }
            currentPrime = Primes.nextPrimeDown(currentPrime);
        }
        return true;
    }

    @Override
    public String doSolve() {
        return "" + LongStream.of(Primes.generatePrimes(100)).filter(x -> isPrimeSummandable(x)).max().getAsLong();
    }

//    @Override
//    public String doSolve() {
//        return "" + LongStream.of(Primes.generatePrimes(1000)).map(p -> getPrimeSum(p)).filter(k -> Primes.isPrime(k) && k < 1000).max().getAsLong();
//    }
}
