package ru.sb.geekbrains.algorithms.tree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Node {
    private NodeType type;
    private int value;
    private Node leftChild;
    private Node rightChild;

    public Node(NodeType type, int value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
        this.type = type;
    }
}
