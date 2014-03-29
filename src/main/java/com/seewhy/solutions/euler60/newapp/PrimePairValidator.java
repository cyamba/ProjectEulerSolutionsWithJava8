package com.seewhy.solutions.euler60.newapp;

import com.seewhy.math.Primes;

/**
 * Created by cbyamba on 2014-03-29.
 */
public class PrimePairValidator {

    public static boolean check(PrimeClub club, Long newPrime) {
        return (club.size() == 0) ? true :
                club.getPrimes().stream().allMatch(x -> check0(x, newPrime));
    }

    protected static boolean check0(Long x, Long newPrime) {
        return Primes.arePrimes(Long.valueOf(x.toString() + newPrime.toString()),
                Long.valueOf(newPrime.toString() + x.toString()));
    }
}
