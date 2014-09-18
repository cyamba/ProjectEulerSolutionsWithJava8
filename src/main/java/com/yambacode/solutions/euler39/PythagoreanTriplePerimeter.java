package com.yambacode.solutions.euler39;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;
import com.yambacode.solutions.euler8.PythagoreanTripleAlgorithm;
import com.yambacode.solutions.euler8.PythagoreanTriples;

import java.util.List;
import java.util.TreeMap;

/**
 * Created by cbyamba on 2011-12-09
 */
public class PythagoreanTriplePerimeter extends AbstractEulerSolver {
    @Override
    public String doSolve() {
        return compute().toString();
    }


    public Number compute() {
        TreeMap<Integer, List<int[]>> allTriplesByCount = new TreeMap<Integer, List<int[]>>();
        Integer max = 0;
        for (int k = 1; k <= 1000; k++) {
            for (int n = 1; n <= n; n++) {
                for (int m = 1; m <= n; m++) {
                    int[] triples = PythagoreanTriples.getABC(k, n, m);
                    Integer size = triples[0] + triples[1] + triples[2];
                    if (PythagoreanTriples.isPythagoreanTriple(triples)) {
                        List<int[]> temp = allTriplesByCount.get(size);
                        if (!isContainedIn(triples, temp)) {
                            temp.add(triples);
                            allTriplesByCount.put(size, temp);
                            if (size > max) {
                                max = size;
                            }
                        }
                    }
                }
            }
        }
        return max;
    }

    private boolean isContainedIn(int[] arr, List<int[]> triples) {
        for (int[] a : triples) {
            if (a[0] != arr[0] || a[1] != arr[1] || a[2] != arr[2]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException("fixme!");
    }
}
