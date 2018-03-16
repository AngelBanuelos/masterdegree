/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.examns.partial1;

/**
 *
 * @author Angel.Sahagun
 */
public class TernaryTree {

    private Node root = null;

    public void createTree(int[] array) {
        for (int i = 0; i < array.length - 1; i = i + 2) {
            addNode(array[i], array[i + 1]);
        }
    }

    public void addNode(int value1, int value2) {
        if (root == null) {
            root = new Node(value1, value2);
        } else {
            Node node = new Node(value1, value2);
            addNode(node, root);
        }
    }

    public String search(Node node, int value) {
        if (node == null) {
            return "";
        }
        if (node.getValues()[0] == value || node.getValues()[1] == value) {
            return "Encontrado";
        } else {
            if (value < node.getValues()[0]) {
                if (node.getChild1() != null) {
                    return search(node.getChild1(), value);
                }
            } else if (value > node.getValues()[0] && value < node.getValues()[1]) {
                if (node.getChild2() != null) {
                    return search(node.getChild2(), value);
                }
            } else {
                if (node.getChild3() != null) {
                    return search(node.getChild3(), value);
                }
            }
        }
        return "";
    }

    private void addNode(Node node, Node root) {
        if (node == null) {
            return;
        }
        if (node.getValues()[1] < root.getValues()[0]) {
            if (root.getChild1() == null) {
                root.setChild1(node);
            } else {
                addNode(node, root.getChild1());
            }
        } else if (node.getValues()[0] > root.getValues()[0] && node.getValues()[1] < root.getValues()[1]) {
            if (root.getChild2() == null) {
                root.setChild2(node);
            } else {
                addNode(node, root.getChild2());
            }
        } else {
            if (root.getChild3() == null) {
                root.setChild3(node);
            } else {
                addNode(node, root.getChild3());
            }
        }
    }

    public static void main(String[] args) {
        TernaryTree tree = new TernaryTree();
        int[] array = {6, 15, 2, 4, 9, 12, 18, 24, 16, 17, 20, 22, 26, 28};
        tree.createTree(array);

        for (int b : array) {
            System.out.println(b + " " + tree.search(b));
        }
        System.out.println("-5 " + tree.search(-5));
        System.out.println("100 " + tree.search(100));

    }

    private String search(int value) {
        return search(root, value);
    }

}
