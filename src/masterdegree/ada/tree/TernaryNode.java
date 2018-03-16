/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.tree;

/**
 *
 * @author Angel.Sahagun
 */
public class TernaryNode {

    private int[] values = new int[2];
    private TernaryNode child1 = null;
    private TernaryNode child2 = null;
    private TernaryNode child3 = null;

    public TernaryNode(int value1, int value2) {
        if (value1 < value2) {
            this.values[0] = value1;
            this.values[1] = value2;
        } else {
            this.values[0] = value2;
            this.values[1] = value1;
        }
    }

    public int[] getValues() {
        return values;
    }

    public void setValues(int[] values) {
        this.values = values;
    }

    public TernaryNode getChild1() {
        return child1;
    }

    public void setChild1(TernaryNode child1) {
        this.child1 = child1;
    }

    public TernaryNode getChild2() {
        return child2;
    }

    public void setChild2(TernaryNode child2) {
        this.child2 = child2;
    }

    public TernaryNode getChild3() {
        return child3;
    }

    public void setChild3(TernaryNode child3) {
        this.child3 = child3;
    }

}
