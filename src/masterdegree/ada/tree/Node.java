/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.tree;

/**
 *
 * @author angel_banuelos
 */
public class Node {

    private int value;
    private int index = -1;
    private Node left;
    private Node right;
    private int formatCount;
    private String format;

    public int getFormatCount() {
        return formatCount;
    }

    public void setFormatCount(int formatCount) {
        this.formatCount = formatCount;
    }

    public String getFormat() {
        format = "";
        for (int i = 0; i < formatCount; i++) {
//            format += "     ";
            format += "\t";
        }
        return format;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) throws InsertNodeException {
        if(this.index != -1 ){
            throw new InsertNodeException("This node already has an index", this);
        }
        this.index = index;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        if (this.index != other.index) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + ", index=" + index + '}';
    }
    
}
