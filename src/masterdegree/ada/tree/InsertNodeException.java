/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.tree;

import masterdegree.ada.tree.exceptions.TreeException;

/**
 *
 * @author Angel.Sahagun
 */
public class InsertNodeException extends TreeException {

    Node node = null;
    
    public InsertNodeException(String message, Node node) {
        super(message);
        this.node = node;
    }

    public Node getNode() {
        return node;
    }
    
}
