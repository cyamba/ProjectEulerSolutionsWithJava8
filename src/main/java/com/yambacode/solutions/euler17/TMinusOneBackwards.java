package com.yambacode.solutions.euler17;

import com.yambacode.solutions.AbstractEulerSolver;

/**
 * Created by cbyamba on 2011-11-01
 */
public class TMinusOneBackwards extends AbstractEulerSolver {

    public Number compute() {
        int sum = 0;
        String talk = null;
        for (int count = 1; count <= 1000; count++) {
            talk = NumberTalkUtil.StringByCount(count);
            System.out.println(talk);
            sum += (talk = talk.trim()).length();
        }
        return sum;
    }


    @Override
    public String doSolve() {
        return compute().toString();
    }
}
