package com.yambacode.solutions;

/**
 * Created by cbyamba on 2014-01-07.
 */
public class EulerResult {

    private EulerSolver solution;
    private String result;
    private long time;

    public EulerResult(EulerSolver solution, String result, long time) {
        this.solution = solution;
        this.result = result;
        this.time = time;
    }

    public String getResult() {
        return result;
    }

    public long getTime() {
        return time;
    }

    public EulerSolver getSolution() {
        return solution;
    }

    @Override
    public String toString() {
        return String.format("Problem : %s\nResult : %s\nExecutionTime : %s ms", solution.getClass().getSimpleName(), result, time);
    }
}
