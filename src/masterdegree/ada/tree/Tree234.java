/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.tree;

import masterdegree.ada.sort.utils.Utils;

/**
 *
 * @author angel_banuelos
 */
public class Tree234 {

    Node234 root;

    public void createTree(int[] array) {
        Node234 root = new Node234(array[0], 0);
        for (int i = 1; i < array.length; i++) {
            Node234 current = root;
            boolean added = false;
            do {
                if (current.getType() == 4) {
                    // if current is leaf and node of type 4 separate.
                    Node234 left = new Node234(current.getValue(0), current.getIndex(0));
                    Node234 right = new Node234(current.getValue(2), current.getIndex(2));

                    if (!current.isLeaf()) {
                        left.addChild(current.getChild(0));
                        left.addChild(current.getChild(1));

                        right.addChild(current.getChild(2));
                        right.addChild(current.getChild(3));

                    }
                    if (current.getParent() == null) {
                        root = new Node234(current.getValue(1), current.getIndex(1));
                        root.addChild(left);
                        root.addChild(right);
                        current = root;
                    } else {
                        Node234 parent = current.getParent();
                        int index = parent.insert(current.getValue(1), current.getIndex(1));
                        parent.addChildren(left, right, index);
                        current = parent;
                    }

                } else if (current.isLeaf()) {
                    current.insert(array[i], i);
                    added = true;
                } else {
                    if (current.getType() == 2) {
                        if (array[i] < current.getValue(0)) {
                            current = current.getChild(0);
                        } else {
                            current = current.getChild(1);
                        }
                    } else { //type 3
                        if (array[i] < current.getValue(0)) {
                            current = current.getChild(0);
                        } else if (array[i] < current.getValue(1)) {
                            current = current.getChild(1);
                        } else {
                            current = current.getChild(2);
                        }
                    }
                }
            } while (!added);
        }
        this.root = root;
    }

    public void print(Node234 node234, int spaces) {
        System.out.println("" + node234.getValues());
        if (node234.isLeaf()) {
            return;
        } else {
            if (node234.getType() == 2) {
                print(node234.getChild(0), spaces + 1);
                print(node234.getChild(1), spaces + 1);
            } else {
                print(node234.getChild(0), spaces + 1);
                print(node234.getChild(1), spaces + 1);
                print(node234.getChild(2), spaces + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {8, 5, 3, 9, 12, 6, 7, 0, 10, 4, 15, 13}; //= Utils.invertedArray(1 << 10);
        Tree234 tree234 = new Tree234();
        tree234.createTree(array);
        System.out.println("" + tree234);
        System.out.println("indexOF " + tree234.search(3));

    }

    @Override
    public String toString() {
        print(root, 0);
        return "";
    }

    public int search(int value) {
        return search(root, value);
    }

    private int search(Node234 node234, int value) {
        int i = node234.getValues().indexOf(value);
        if (i >= 0) {
            return node234.getIndex(i);
        }
        if (node234.isLeaf()) {
            return -1;
        }
        if (node234.getType() == 2) {
            if (value < node234.getValue(0)) {
                return search(node234.getChild(0), value);
            }
            return search(node234.getChild(1), value);
        }
        //if (node234.getType() == 3) {
        if (value < node234.getValue(0)) {
            return search(node234.getChild(0), value);
        }
        if (value < node234.getValue(1)) {
            return search(node234.getChild(1), value);
        }
        return search(node234.getChild(2), value);
    }

}
