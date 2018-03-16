package masterdegree.ada.homeworks.session8;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @authors 
 * BANUELOS SAHAGUN ANGEL DE JESUS 
 * FLORES DIAZ JOSE ARMANDO
 * GARCIA FERMIN GENARO
 * 
 */
public class Justicia {

    // Node of an n-ary Tree
    public static class Node implements Comparable<Node>{
        
        private long value;
        private int expectedChildren;
        private final ArrayList<Node> children;

        public Node(){
            super();
            this.value = 0;
            this.expectedChildren = 0;
            children = new ArrayList<>();
        }
        
        public Node(long value, int expectedChildren){
            super();
            this.value = value;
            this.expectedChildren = expectedChildren;
            children = new ArrayList<>();
        }   
       
        public void setValue(long value){ 
            this.value = value; 
        }
        
        public long getValue(){ 
            return value; 
        }
        
        public void setExpectedChildren(int expectedChildren){ 
            this.expectedChildren = expectedChildren;
        }
        
        public int getExpectedChildren(){ 
            return this.expectedChildren; 
        }
        
        public ArrayList<Node> getChildren(){ 
            return children; 
        }
        
        public int getNumberOfChildren(){ 
            return children.size();
        }
        
        public boolean isLeaf(){ 
            return children.isEmpty(); 
        }
        
        public void addChild(Node child){ 
            children.add(child); 
        }
        
        @Override
        public int compareTo(Node node){
            if(this.value < node.value)return -1;
            if(this.value > node.value)return 1;
            else return 0;
        }
    }
    
    // Create the tree with the ArrayList Node
    public static Node recursiveNode(Node root, ArrayList<Node> list, int min, int offset){
        Node current = root;
        offset += root.getExpectedChildren();
       
        for(int i = min; i < min + root.getExpectedChildren(); i++){
            Node newN = list.get(i);

            if(newN.getExpectedChildren()>0){
                 newN = recursiveNode(newN,list,offset, offset);
            }
            if(newN != null){
                offset += newN.getExpectedChildren();
                current.addChild(newN);
            }
        }
        return current;
    }
    
    
    public static Node createTree(ArrayList<Node> list){
        Node root = list.get(0);
        int min = 1;
        int offset = min;
        root = recursiveNode(root, list, min, offset);
        return root;
    }
    
    public static boolean isSorted(Node current){
        ArrayList<Node> children = current.getChildren();
        if(current.isLeaf()) return true;
        for(Node c:children){
            if(!c.isLeaf()){
                if(!isSorted(c))
                return false;
            }
        }
        for(Node c:children){
            if(current.getValue() < c.getValue()){
                return false;
            }
        }
        return true;
    }
    
    /* =================> Recursive Sort <====================  */
    public static Node recursiveSortTree(Node current){
        if(current.isLeaf()) return current;
        ArrayList<Node> children = current.getChildren();
        for(Node c : children){
                c = recursiveSortTree(c);
        }
        for(Node c:children){
            if(current.getValue() < c.getValue()){
                long tmp = c.getValue();
                c.setValue(current.getValue());
                current.setValue(tmp);
            }
        }
        return current;
    }
    /* =================> Recursive Sort <====================  */

    public static Node sortTree(Node root){
        root = recursiveSortTree(root);
        return root;
    }

    public static void printTree(Node root){
        ArrayList<Node> toPrint = new ArrayList<>();
        toPrint.add(root);
        while(toPrint.size()>0){
            for(Node n: toPrint){
                //System.out.println("" + n.getValue() + " " + n.getNumberOfChildren()); // for debug porpouse
                System.out.println(n.getValue());
            }
            ArrayList<Node> tmp = new ArrayList<>();
            for(int i = 0; i < toPrint.size(); i++ ){ 
                ArrayList<Node> current = toPrint.get(i).getChildren();
                for(int j = 0; j < current.size(); j++){
                    tmp.add(current.get(j));
                }
            }
            toPrint.clear();
            toPrint = tmp;
         }
    }
    
    public static void doJustice(){
        System.out.println("\n Input"); 
        // scanning from the input user  
        try (Scanner sc = new Scanner(System.in)){
            int N = sc.nextInt();
            // a tree for a case
            ArrayList<Node> trees = new ArrayList<>();
            // reading all cases
            for(int n = 0; n < N; n++){
                int nodes = sc.nextInt(); // nodes of the tree
                ArrayList<Node> list = new ArrayList<>();
                // insert nodes in a temporary list
                for(int i = 0; i < nodes; i++){
                    long v = sc.nextLong(); // value
                    int c = sc.nextInt(); // expected children
                    Node newN = new Node(v,c);
                    list.add(newN);
                }
                // create the tree for each case
                trees.add(createTree(list));  
            }
            // Print each tree
            System.out.println("\n Output");
            for(int n = 0; n < N; n++){
                Node tree = trees.get(n);
                if(isSorted(tree)){
                    System.out.println("JUSTICIA");
                }else{
                    while(!isSorted(tree))
                        tree = sortTree(tree);
                    printTree(tree);
                }
                System.out.println("");
            }
        }
    }      
    
    public static void main(String[] args){
        doJustice();
    }
}
