/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.mac.session5;

import java.util.Objects;

/**
 *
 * @author angel_banuelos
 * @description Vertex Class
 *
 *
 */
public class Vertex {

    private int edges = 0;
    private String label;
    private String bipartiteHelper = "";

    public Vertex(String label) {
        this.label = label;
    }

    public int getEdges() {
        return edges;
    }

    public String getLabel() {
        return label;
    }

    public void setEdges(int edges) {
        this.edges = edges;
    }

    public void setBipartiteHelper(String bipartiteHelper) {
        if (this.bipartiteHelper.equals(bipartiteHelper)) {
            return;
        } else if (this.bipartiteHelper.isEmpty()) {
            this.bipartiteHelper = bipartiteHelper;
        } else {
            this.bipartiteHelper = "Error";
        }
    }

    public String getBipartiteHelper() {
        return bipartiteHelper;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vertex other = (Vertex) obj;
        if (!Objects.equals(this.label, other.label)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return label;
    }
    
    

}
