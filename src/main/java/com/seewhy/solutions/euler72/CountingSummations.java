package com.seewhy.solutions.euler72;

import com.seewhy.solutions.AbstractEulerSolver;
import com.seewhy.solutions.EulerRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.LongStream;

/**
 * 1 1 1 1 1       (4,0,0,0,0)
 * 1 1 1  2        (3,1,0,0,0)
 * 1  2 2          (1,2
 * <p/>
 * Created by cbyamba on 2014-02-15.
 */
public class CountingSummations extends AbstractEulerSolver {


    private static HashMap<Tuple, Long> partitionCache = new HashMap<>();

    /**
     * p(n,k) = p(n-1,k-1) + p(n-k,k)
     * p(n,n) = 1, p(n,0)= 0
     *
     * @param n
     * @param k
     * @return
     */
    public static long p(long n, long k) {
        if (k == 0) {
            return 0L;
        }
        if (n == k) {
            return 1L;
        }
        Tuple key = new Tuple(n, k);
        if (partitionCache.containsKey(key)) {
            return partitionCache.get(key);
        } else {

        }
        long p1 = p(n - 1, k - 1);
        partitionCache.put(new Tuple(n - 1, k - 1), p1);
        long p2 = p(n - k, k);
        partitionCache.put(new Tuple(n - k, k), p2);
        return p1 + p2;
    }


    /**
     * @return
     */
    @Override
    public String doSolve() {
        Object[] objects = LongStream.rangeClosed(0, 2).flatMap(n -> LongStream.rangeClosed(0, n).map(k -> p(n, k))).boxed().toArray();
        return Arrays.toString(objects);
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new CountingSummations());
    }

}
