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
public class DeleteTreeException extends TreeException{

    private Node node;
    
    public DeleteTreeException(String message, Node node) {
        super(message);
        
    }

    public Node getNode() {
        return node;
    }
    
}
