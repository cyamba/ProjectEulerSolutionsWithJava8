package com.yambacode.solutions.euler18.experiments.gredoid;

import com.yambacode.solutions.AbstractEulerSolver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbyamba on 2014-09-18.
 */
public class GreedoidImpl extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        return null;
    }


    private String triangleStr =
            "75\n" +
                    "95 64\n" +
                    "17 47 82\n" +
                    "18 35 87 10\n" +
                    "20 04 82 47 65\n" +
                    "19 01 23 75 03 34\n" +
                    "88 02 77 73 07 63 67\n" +
                    "99 65 04 28 06 16 70 92\n" +
                    "41 41 26 56 83 40 80 70 33\n" +
                    "41 48 72 33 47 32 37 16 94 29\n" +
                    "53 71 44 65 25 43 91 52 97 51 14\n" +
                    "70 11 33 28 77 73 17 78 39 68 17 57\n" +
                    "91 71 52 38 17 14 91 43 58 50 27 29 48\n" +
                    "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" +
                    "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

    private int doneCount = 0;

    private Integer[][] foodForGreed;

    {
        String[] split = triangleStr.split("\n");
        String[][] tempArr = new String[split.length][];
        int count = 0;
        for (String s : split) {
            tempArr[count++] = s.split(" ");
        }
        foodForGreed = new Integer[split.length][];
        for (int i = 0; i < tempArr.length; i++) {
            foodForGreed[i] = new Integer[tempArr[i].length];
            for (int j = 0; j < tempArr[i].length; j++) {
                foodForGreed[i][j] = Integer.parseInt(tempArr[i][j]);
            }
        }
    }

    public Number compute() {

        List<GreedyConsumer> workers = new ArrayList<GreedyConsumer>();
        workers.add(new GreedyConsumer(this, 1));
        workers.add(new GreedyConsumer(this, 2));
        int count = 0;
        for (GreedyConsumer w : workers) {
            new Thread(workers.get(count++)).start();
        }
        while (doneCount < 2) {
            //wait for workers to be done.
        }
        Integer max = 0;
        for (GreedyConsumer w : workers) {
            if (w.getResult() > max) {
                max = w.getResult();
            }
        }
        return max;
    }

    public void workerDone() {
        doneCount++;
    }

    public Integer[][] getFoodForGreed() {
        return foodForGreed;
    }
}
