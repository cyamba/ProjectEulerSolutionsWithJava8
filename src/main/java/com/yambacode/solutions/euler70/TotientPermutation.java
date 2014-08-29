package com.yambacode.solutions.euler70;

import com.yambacode.common.collections.Lists;
import com.yambacode.common.io.Printer;
import com.yambacode.math.Divisibility;
import com.yambacode.math.Permutations;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.math.BigInteger;
import java.util.List;

import static com.yambacode.solutions.euler97.BigIntegers.*;

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
