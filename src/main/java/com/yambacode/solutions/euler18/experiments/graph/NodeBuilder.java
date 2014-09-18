package com.yambacode.solutions.euler18.experiments.graph;

import com.yambacode.common.pattern.Builder;

/**
 * Created by cbyamba on 2011-11-25
 */
public class NodeBuilder implements Builder<Node> {

    private Node node;

    public static NodeBuilder create() {
        return new NodeBuilder(new Node());
    }

    public static NodeBuilder create(Node node) {
        return new NodeBuilder(node);
    }

    private NodeBuilder(Node node) {
        this.node = node;
    }

    public NodeBuilder mother(Node mother) {
        node.setMother(mother);
        return this;
    }

    public NodeBuilder father(Node father) {
        node.setFather(father);
        return this;
    }

    public NodeBuilder leftChild(Node leftChild) {
        node.setLeftChild(leftChild);
        return this;
    }

    public NodeBuilder rightChild(Node rightChild) {
        node.setRightChild(rightChild);
        return this;
    }

    public NodeBuilder value(Number value) {
        node.setValue(value);
        return this;
    }

    public NodeBuilder level(Integer level) {
        node.setLevel(level);
        return this;
    }

    public Node build() {
        if (node == null) {
            throw new IllegalStateException();
        }
        return node;
    }
}
