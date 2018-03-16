/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.tree;

import java.util.LinkedList;

/**
 *
 * @author angel_banuelos
 */
public class Node234 {

    private LinkedList<Integer> values = new LinkedList();
    private LinkedList<Integer> indixes = new LinkedList();
    private LinkedList<Node234> children = new LinkedList();
    private Node234 parent;

    public Node234(int value, int index) {
        this.values.add(value);
        this.indixes.add(index);
        parent = null;
    }

    public int getValue(int index) {
        return values.get(index);
    }

    public int getIndex(int value) {
        return indixes.get(value);
    }

    public int getType() {
        return values.size() + 1;
    }

    public Node234 getParent() {
        return parent;
    }

    public Node234 getChild(int index) {
        return children.get(index);
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public int insert(int value, int index) {
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) > value) {
                values.add(i, value);
                indixes.add(i, i);
                return i;
            }
        }
        values.add(value);
        indixes.add(index);
        return indixes.size() - 1;
    }

    public void addChild(Node234 child) {
        children.add(child);
        child.parent = this;
    }

    public void addChildren(Node234 child1, Node234 child2, int index) {
        children.set(index, child1);
        children.add(index + 1, child2);
        child1.parent = this;
        child2.parent = this;
    }

    public LinkedList<Integer> getValues() {
        return values;
    }

}
