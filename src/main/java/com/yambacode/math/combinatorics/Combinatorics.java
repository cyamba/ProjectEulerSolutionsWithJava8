package com.yambacode.math.combinatorics;

import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-01-10.
 */
public class Combinatorics {

    public static BigInteger factorial(int n) {
        BigInteger product = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            product = product.multiply(BigInteger.valueOf(i));
        }
        return product;
    }

    public static BigInteger combinations(int n, int k) {
        return factorial(n).divide(factorial(k).multiply(factorial(n - k)));
    }

    /**
     * This is very ineffective since there is a binomial identity simplifying this sum.
     *
     * @param upFrom
     * @param downTo
     * @param k
     * @return
     */
    @Deprecated
    public static BigInteger rangeSumOfCombinationsOverFixK(int upFrom, int downTo, int k) {
        return IntStream
                .rangeClosed(downTo, upFrom)
                .boxed()
                .map(i -> combinations(i, k))
                .reduce((x, y) -> x.multiply(y))
                .get();
    }

    public static BigInteger diffOfCombinationSumsOverFixK(int higher, int lower, int k) {
//        Printer.print(String.format("diffOfCombinationSumsOverFixK(%s,%s,%s)",higher,lower,k));
        BigInteger comb1 = combinations(higher, k);
        BigInteger com2 = combinations(lower, k);
        return comb1.subtract(com2);
    }
}
