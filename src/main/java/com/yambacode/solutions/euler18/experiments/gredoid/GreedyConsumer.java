package com.yambacode.solutions.euler18.experiments.gredoid;

/**
 * Created by cbyamba on 2011-11-05
 */

public class GreedyConsumer implements Runnable {

    private GreedoidImpl mainAlgorithm;

    private Integer result;

    private Integer id;

    public GreedyConsumer(GreedoidImpl mainAlgorithm, Integer id) {
        this.mainAlgorithm = mainAlgorithm;
    }

    public void run() {
        Integer[][] food = mainAlgorithm.getFoodForGreed();
        int yPos = 0;
        int xPos = id % 2;


        int currentSum = food[0][0];

        while (yPos < food.length - 1) {
            ++yPos;
            //      Math.(food[yPos][xPos], food[yPos][xPos]);
        }

    }

    public void imDone() {
        mainAlgorithm.workerDone();
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getId() {
        return id;
    }

}
