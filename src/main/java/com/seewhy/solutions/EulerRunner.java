package com.seewhy.solutions;

import com.seewhy.solutions.euler60.PrimePairSets;

import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-01-16.
 */
public class EulerRunner {

    public static void main(String... args) {
        getEulerSolver().solve();
    }


    public static void runEulerSolvers(EulerSolver... solvers) {
        Stream.of(solvers).parallel().forEachOrdered(solver -> solver.solve());
    }

    public static EulerSolver getEulerSolver() {
        return new PrimePairSets();
    }
}
