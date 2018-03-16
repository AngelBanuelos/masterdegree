/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.mac.session5;

/**
 *
 * @author angel_banuelos
 * @description This Class contains a common methods to analyze Graphs.
 */
public class GraphUtils {

    public static boolean isBipartite(Vertex[] verticesArray) {
        for (int i = 0; i < verticesArray.length; i++) {
            if (verticesArray[i].getBipartiteHelper().equals("Error")) {
                return false;
            }
        }
        return true;
    }

    public static int countEdges(int[][] adjacencyMatrix) {
        int count = 0;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                count += adjacencyMatrix[i][j];
            }
        }
        return count;
    }

    public static boolean existsVertex(Vertex vertex, Vertex[] verticesArray) {
        boolean exists = false;
        for (int i = 0; i < verticesArray.length; i++) {
            if (verticesArray[i] != null && verticesArray[i].equals(vertex)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public static void printBipartiteConjuntions(Vertex[] verticesArray) {
        String aSubCon = "";
        String bSubCon = "";
        for (int i = 0; i < verticesArray.length; i++) {
            if (verticesArray[i].getBipartiteHelper().equals("A")) {
                aSubCon += verticesArray[i].getLabel() + ",";
            } else if (verticesArray[i].getBipartiteHelper().equals("B")) {
                bSubCon += verticesArray[i].getLabel() + ",";
            }
        }
        aSubCon = aSubCon.length() != 0 ? aSubCon.substring(0, aSubCon.length() - 1) : "";
        bSubCon = bSubCon.length() != 0 ? bSubCon.substring(0, bSubCon.length() - 1) : "";
        System.out.println("A{" + aSubCon + "}" + " B{" + bSubCon + "}");
    }

}
