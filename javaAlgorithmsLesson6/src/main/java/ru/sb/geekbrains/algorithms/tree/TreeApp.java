package ru.sb.geekbrains.algorithms.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TreeApp {
    private static int MAX_TREE_DEPTH = 3;
    private static int AMOUNT_OF_TREES = 1;
    private static int MIN_VALUE_FOR_TREE_NODE = -100;
    private static int MAX_VALUE_FOR_TREE_NODE = 100;
    private static float PERCENT_OF_DEPTH_TO_CHECK_BALANCE_OF_A_TREE = 30f;
    private static int MAX_DIFFERENCE_BETWEEN_AMOUNT_OF_ELEMENTS_FOR_BALANCED_TREES = Math.round(MAX_TREE_DEPTH*PERCENT_OF_DEPTH_TO_CHECK_BALANCE_OF_A_TREE/100);

    public static void main(String[] args) {
        List<Node> treeRoots = new LinkedList<>();
        for (int i = 0; i < AMOUNT_OF_TREES; i++) {
            treeRoots.add(createTree());
        }
        System.out.println("Создано деревьев: " + AMOUNT_OF_TREES);
        int amountOfBalancedTrees = 0;
        int amountOfUnBalancedTrees = 0;
        for (Node rootNode : treeRoots) {
            if (chechIfTreeBalanced(rootNode)) {
                amountOfBalancedTrees++;
            } else {
                amountOfUnBalancedTrees++;
            }
        }
        System.out.print("Из них сбалансированных ");
        System.out.print(amountOfBalancedTrees + " (" + (amountOfBalancedTrees * 100 / AMOUNT_OF_TREES) + "%)");
        System.out.println(", несбалансированных " + amountOfUnBalancedTrees + " (" + (amountOfUnBalancedTrees * 100 / AMOUNT_OF_TREES) + "%)");
        System.out.println("(дерево является сбалансированным, если количество ветвей справа и слева от корня равно или разница не превышает "+PERCENT_OF_DEPTH_TO_CHECK_BALANCE_OF_A_TREE+"% от глубины дерева - "+PERCENT_OF_DEPTH_TO_CHECK_BALANCE_OF_A_TREE+"% от " + MAX_TREE_DEPTH + " = " + MAX_DIFFERENCE_BETWEEN_AMOUNT_OF_ELEMENTS_FOR_BALANCED_TREES+")");
        int treeNumber = 0;
        for (Node rootNode : treeRoots) {
            treeNumber++;
            System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.println("Дерево номер " + treeNumber);
            System.out.println("Общее количество элементов: " + countTreeElements(rootNode));
            System.out.println("Элементов справа от корня: " + (rootNode.getRightChild() != null ? countTreeElements(rootNode.getRightChild()) : "0"));
            System.out.println("Элементов слева от корня: " + (rootNode.getLeftChild() != null ? countTreeElements(rootNode.getLeftChild()) : "0"));
            if (chechIfTreeBalanced(rootNode)) {
                System.out.println("Дерево сбалансировано");
            } else {
                System.out.println("Дерево не сбалансировано");
            }
            System.out.println("-------------------------------------------");
            printTree(rootNode, null);
        }
    }

    private static void printTree(Node currentNode, List<Node> parentNodes) {
        if (parentNodes != null) {
            for (Node node : parentNodes) {
                System.out.print("(" + node.getType().getShortName() + ") " + node.getValue() + " -> ");
            }
        }
        System.out.println("(" + currentNode.getType().getShortName() + ") " + currentNode.getValue());
        if (currentNode.getLeftChild() != null) {
            List<Node> newParentNodes;
            if (parentNodes != null) {
                newParentNodes = new LinkedList<>(parentNodes);
            } else {
                newParentNodes = new LinkedList<>();
            }
            newParentNodes.add(currentNode);
            printTree(currentNode.getLeftChild(), newParentNodes);
        }
        if (currentNode.getRightChild() != null) {
            List<Node> newParentNodes;
            if (parentNodes != null) {
                newParentNodes = new LinkedList<>(parentNodes);
            } else {
                newParentNodes = new LinkedList<>();
            }
            newParentNodes.add(currentNode);
            printTree(currentNode.getRightChild(), newParentNodes);
        }
    }

    private static boolean chechIfTreeBalanced(Node rootNode) {
        int amountOfRightElements = 0;
        int amountOfLeftElements = 0;
        if (rootNode.getRightChild() != null) {
            amountOfRightElements = countTreeElements(rootNode.getRightChild());
        }
        if (rootNode.getLeftChild() != null) {
            amountOfLeftElements = countTreeElements(rootNode.getLeftChild());
        }
        if ((amountOfLeftElements == amountOfRightElements) || (Math.abs(amountOfLeftElements - amountOfRightElements) <= MAX_DIFFERENCE_BETWEEN_AMOUNT_OF_ELEMENTS_FOR_BALANCED_TREES)) {
            return true;
        }
        return false;
    }

    private static int countTreeElements(Node startNode) {
        int amountOfElements = 1;
        if (startNode.getLeftChild() != null) {
            amountOfElements += countTreeElements(startNode.getLeftChild());
        }
        if (startNode.getRightChild() != null) {
            amountOfElements += countTreeElements(startNode.getRightChild());
        }
        return amountOfElements;
    }

    private static Node createTree() {
        Node rootNode = new Node(NodeType.ROOT, generateValueForANode());
        int baseTreeLevel = 1;
        int subTreeLevel = 0;
        while (subTreeLevel < MAX_TREE_DEPTH-baseTreeLevel) {
            subTreeLevel = insertNodeInATree(rootNode, new Node(NodeType.NONE, generateValueForANode()));
        }
        return rootNode;
    }

    private static int generateValueForANode() {
        return (new Random()).nextInt(MAX_VALUE_FOR_TREE_NODE - MIN_VALUE_FOR_TREE_NODE) + MIN_VALUE_FOR_TREE_NODE;
    }

    private static int insertNodeInATree(Node currentNode, Node newNode) {
        int treeLevel = 0;
        int currentNodeValue = currentNode.getValue();
        int newNodeValue = newNode.getValue();
        if (currentNodeValue == newNodeValue) {
            return treeLevel;
        } else if (currentNodeValue < newNodeValue) {
            //go right
            treeLevel++;
            if (currentNode.getRightChild() == null) {
                newNode.setType(NodeType.RIGHT_CHILD);
                currentNode.setRightChild(newNode);
                return treeLevel;
            } else {
                treeLevel += insertNodeInATree(currentNode.getRightChild(), newNode);
            }
        } else {
            //go left
            treeLevel++;
            if (currentNode.getLeftChild() == null) {
                newNode.setType(NodeType.LEFT_CHILD);
                currentNode.setLeftChild(newNode);
                return treeLevel;
            } else {
                treeLevel += insertNodeInATree(currentNode.getLeftChild(), newNode);
            }
        }
        return treeLevel;
    }
}
