/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.tree;

import masterdegree.ada.sort.Heap;
import masterdegree.ada.sort.utils.Utils;
import masterdegree.ada.tree.exceptions.TreeException;

/**
 *
 * @author angel_banuelos
 */
public class Tree {

    private Node root = null;
    private int index = 0;

    public Node createTree(int[] array) throws TreeException {
        index = 0;
        if (root != null) {
            throw new TreeException("Tree already exist, You need to clear the existing tree");
        }
        root = new Node();
        root.setIndex(index);
        root.setValue(array[index++]);
        root.setFormatCount((array.length / 3));
        for (int i = 1; i < array.length; i++) {
            addNode(array[i]);
        }
        return root;
    }

    @Override
    public String toString() {
        return print(root, "");
    }

    private String print(Node root, String treeToString) {
        if (root == null) {
            return treeToString;
        }
        treeToString += root.getFormat() + root.getValue() + " " + root.getIndex() + "\n";

        treeToString = print(root.getLeft(), treeToString);
        return treeToString = print(root.getRight(), treeToString);
    }

    public void addNode(Node node) throws InsertNodeException {
        if (root == null || node == null) {
            root = (node != null ? node : root);
            return;
        }
        Node iterator = root;
        while (true) {
            if (node.getValue() > iterator.getValue()) {
                if (iterator.getRight() == null) {
                    node.setFormatCount(iterator.getFormatCount() + 1);
                    if (node.getIndex() == -1) {
                        node.setIndex(index++);
                    }
                    iterator.setRight(node);
                    break;
                } else {
                    iterator = iterator.getRight();
                }
            } else {
                if (iterator.getLeft() == null) {
                    node.setFormatCount(iterator.getFormatCount() - 1);
                    if (node.getIndex() == -1) {
                        node.setIndex(index++);
                    }
                    iterator.setLeft(node);
                    break;
                } else {
                    iterator = iterator.getLeft();
                }
            }
        }
    }

    public void removeNode(Node node) throws InsertNodeException {
        if (node == null) {
            return;
        }
        if (root.equals(node)) {
            Node left = root.getLeft();
            Node right = root.getRight();
            root = null;
            root = left;
            addNode(right);
            return;
        }
        Node iterator = root;
        Node previous = root;
        boolean right = false;
        while (true) {
            if (iterator.equals(node)) {
                Node leftNode = iterator.getLeft();
                Node rightNode = iterator.getRight();
                if (right) {
                    previous.setRight(null);
                } else {
                    previous.setLeft(null);
                }
                addNode(leftNode);
                addNode(rightNode);
                break;

            }
            if (node.getValue() > iterator.getValue()) {
                if (iterator.getRight() == null) {
                    break;
                } else {
                    right = true;
                    previous = iterator;
                    iterator = iterator.getRight();
                }
            } else {
                if (iterator.getLeft() == null) {
                    break;
                } else {
                    right = false;
                    previous = iterator;
                    iterator = iterator.getLeft();
                }
            }
        }
    }

    public void clearTree() {
        root = null;
    }

    public Node getNode(int index, Node root) {
        if (index == -1 || root == null || root.getIndex() == index) {
            return root;
        }
        Node node = getNode(index, root.getLeft());
        return getNode(index, (node == null ? root.getRight() : node));
    }

    public Node getNode(Node node, Node root) {
        return getNode(node.getIndex(), root);
    }

    public Node getNodeByValue(int value, Node root) {
        if (root == null || root.getValue() == value) {
            return root;
        }
        Node node = null;
        if (value < root.getValue()) {
            node = getNodeByValue(value, root.getLeft());
        }

        return getNodeByValue(value, (node == null ? root.getRight() : node));
    }

    public Node getRoot() {
        return root;
    }

    public void addNode(int value) throws InsertNodeException {
        Node node = new Node();
        node.setValue(value);
        addNode(node);
    }

    public Node createTreeBalanced(int[] array) throws TreeException {
        index = 0;
        if (root != null) {
            throw new TreeException("Tree already exist, You need to clear the existing tree");
        }
        if (!Utils.isSorted(array)) {
            Heap heapSort = new Heap();
            heapSort.sort(array);
        }
        root = new Node();
        root.setIndex(index);
        root.setValue(array[array.length / 2]);
        root.setFormatCount((array.length / 3));

        addNode(array, 0, array.length / 2, array.length);

        return root;
    }

    public void addNode(int[] array, int start, int half, int end) {
        System.out.println("" + half);
        if (half == 0) {
            return;
        }
        end = half;
        half = (end - start) / 2;
        addNode(array, start, half, end);
        start = half;
        half = (end - start) / 2;
        addNode(array, start, half, end);
        
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32};
        tree.addNode(array, 0, array.length / 2, array.length);
    }

}
