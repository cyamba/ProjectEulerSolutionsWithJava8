package com.seewhy.solutions;

import com.seewhy.common.io.Printer;

/**
 * Created by cbyamba on 2014-01-07.
 */
public abstract class AbstractEulerSolver implements EulerSolver {

    @Override
    public EulerResult solve() {
        long start = System.currentTimeMillis();
        String result = this.doSolve();
        long executedTime = System.currentTimeMillis() - start;
        EulerResult eulerResult = new EulerResult(this, result, executedTime);
        Printer.print(eulerResult);
        return eulerResult;
    }

    public abstract String doSolve();
}
