package com.yambacode.solutions.euler18.experiments.graph;

import com.yambacode.solutions.AbstractEulerSolver;

import java.util.LinkedHashSet;

/**
 * Created by cbyamba on 2014-09-18.
 */
public class GraphSolutionExperiment extends AbstractEulerSolver {


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

    private Integer[][] foodForGreed;

    //parse the number triangle
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

    //TODO increment and set levels on each node.

    private Node graph = NodeBuilder.create().build();

    //build the corresponding graph
    {
        Node current = graph;

        current.setFather(null);
        current.setMother(null);
        current.setLeftChild(NodeBuilder.create()
                .father(graph)
                .value(foodForGreed[1][0])
                .build());
        current.setRightChild(NodeBuilder.create()
                .father(graph)
                .value(foodForGreed[1][1])
                .build());

        current = current.getLeftChild();

        for (int y = 1; y < foodForGreed.length - 1; y++) {
            for (int x = 0; x < foodForGreed[y].length; x++) {
                populateNode(current, x, foodForGreed[y + 1][x], foodForGreed[y + 1][x + 1]);
                goRight(current, x);
            }
        }
    }

    //delete either mother of father for each child with both mother and child. "custody battle algorithm"
    {
        Node current = null;
        for (int y = 2; y < foodForGreed.length - 1; y++) {
            for (int x = 0; x < foodForGreed[y].length; x++) {
                motherOrFather(current);
                goRight(current, x);
            }
        }

    }

    private Node populateNode(Node current, int x, int leftValue, int rightValue) {

        Node leftChild = NodeBuilder.create()
                .value(leftValue)
                .build();

        Node rightChild = NodeBuilder.create()
                .value(rightValue)
                .build();

        if (x % 2 == 0) {
            leftChild.setFather(current);
            rightChild.setMother(current);
        } else {
            leftChild.setMother(current);
            rightChild.setFather(current);
        }
        return current;
    }

    /**
     * custody battle moment of truth
     *
     * @param currentNode
     */
    private void motherOrFather(Node currentNode) {
        if (currentNode.getValue().intValue() + currentNode.getFather().getValue().intValue()
                < currentNode.getValue().intValue() + currentNode.getMother().getValue().intValue()) {
            currentNode.setFather(null);
        } else {
            currentNode.setMother(null);
        }
    }

    private Node goRight(Node current, int x) {
        return current.getFather().getRightChild();
    }

    LinkedHashSet<Boolean> lastBinaryRoute = new LinkedHashSet<Boolean>();

    public Number compute() {
        //TODO traverse the resulted binary graph with two threads
        Integer sum = 0;
        Node current = graph;
        Node leftChild = null;
        Node rightChild = null;
        sum += current.getValue().intValue();
        while (current.getLevel() < foodForGreed.length) {
            Node child = getStrongestBound(current.getLeftChild(), current.getRightChild());
            if (child == null) {
                sum = 0;
                current = backTrack(current);
            } else {
                current = child;
                sum += current.getValue().intValue();
            }
        }
        return sum;
    }

    private Node getStrongestBound(Node leftChild, Node rightChild) {
        if (leftChild != null && rightChild != null) {
            return leftChild.getValue().intValue() > rightChild.getValue().intValue() ?
                    leftChild : rightChild;
        }
        return (leftChild == null) ? rightChild : leftChild;
    }

    /**
     * Go back to the node that was the root of wrong choice of path
     *
     * @param current
     * @return
     */
    private Node backTrack(Node current) {
        //TODO U DO!
        return null;
    }

    @Override
    public String doSolve() {
        return compute().toString();
    }
}

