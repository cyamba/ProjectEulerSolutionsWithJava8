package com.yambacode.solutions.euler60.newapp;

import com.yambacode.common.collections.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * Created by cbyamba on 2014-03-29.
 */
public class PrimeClub {

    //unparallizable
    private List<Long> primes = Lists.newArrayList();

    public PrimeClub add(Long candidate) {
        if (PrimePairValidator.check(this, candidate)) {
            primes.add(candidate);
        }
        return this;
    }

    public int size() {
        return primes.size();
    }

    public long sum() {
        return primes.isEmpty() ? 0 :
                primes.stream().mapToLong(x -> x).sum();
    }

    public List<Long> getPrimes() {
        return primes;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(primes.toArray());
    }
}
