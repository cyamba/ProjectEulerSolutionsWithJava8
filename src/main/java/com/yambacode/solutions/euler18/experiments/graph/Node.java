package com.yambacode.solutions.euler18.experiments.graph;

/**
 * Created by cbyamba on 2011-11-25.
 */
public class Node {


    private Node mother;
    private Node father;

    private Node leftChild;
    private Node rightChild;

    private Number value;

    private Integer level;

    public Node() {

    }

    public Node getMother() {
        return mother;
    }

    public void setMother(Node mother) {
        this.mother = mother;
    }

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return new StringBuilder("[" + value + "]")
                .append("\n").append(" ").append("/").append("\\")
                .append("\n").append(leftChild.toString()).append(rightChild.toString())
                .toString();
    }
}

