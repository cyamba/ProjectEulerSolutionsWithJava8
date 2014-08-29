package com.seewhy.solutions.euler70;

import com.seewhy.common.collections.Lists;
import com.seewhy.common.io.Printer;
import com.seewhy.math.Divisibility;
import com.seewhy.math.Permutations;
import com.seewhy.solutions.AbstractEulerSolver;
import com.seewhy.solutions.EulerRunner;

import java.math.BigInteger;
import java.util.List;

import static com.seewhy.solutions.euler97.BigIntegers.*;

/**
 * Created by cbyamba on 2014-08-28.
 */
public class TotientPermutation extends AbstractEulerSolver {

    //private static final long SIZE = 10_000_000l;
    private static final long SIZE = 100l;

    @Override
    public String doSolve() {
        return findMinimum(SIZE).toString();
    }

    public BigInteger findMinimum(long size) {
        BigInteger upper = _(size);
        return findMinimum0(upper, priorPrime(upper), _1, _1, Lists.newArrayList());
    }

    public BigInteger findMinimum0(BigInteger upper, BigInteger prime, BigInteger lastPrime, BigInteger product, List<BigInteger> primes) {
        Printer.print("new recursion");
        if (Permutations.arePermutations(product, Divisibility.totient(primes).toBigInteger()) && product.compareTo(upper) > 0) {
            return product.divide(lastPrime);
        }
        BigInteger prime1 = priorPrime(prime);
        Printer.print(String.format("new prior prime %s product %s", prime1, product));
        primes.add(prime);
        return findMinimum0(upper, prime1, prime, product.multiply(prime), primes);
    }


    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new TotientPermutation());
    }

}
