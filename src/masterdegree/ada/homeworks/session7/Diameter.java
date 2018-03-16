
package masterdegree.ada.homeworks.session7;

/**
 * @authors 
 * BANUELOS SAHAGUN ANGEL DE JESUS 
 * FLORES DIAZ JOSE ARMANDO
 * GARCIA FERMIN GENARO
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


public class Diameter {
 
    static int INF = Integer.MAX_VALUE;
    
    public static class Network{
        public int[][] network;
        public  Network(int[][] net){
            this.network = net;
        }

        public void printNetWork(){
            for(int i=0; i<network.length; i++){
                int[] dist = network[i];
                System.out.println(Arrays.toString(dist));
            }
        }        
        
        public int getMax(int[] array){
            int max = 0;
            for(int i = 0; i<array.length; i++)
                if(array[i]>max)
                    max = array[i];
            return max;
        }
        
        public int getDiameter(){
            int diameter = 0;
            for(int i=0; i<network.length; i++){
                int[] distances = dijkstra(network,i);
                int newDiameter = getMax(distances);
                if(newDiameter > diameter)
                    diameter = newDiameter;
            }
            return diameter;
        }
        
	public static int[] dijkstra(int[][] graph, int start) {
		Stack<Integer> nodeStack = new Stack<Integer>(); 
		Stack<Integer>  distStack = new Stack<Integer>();
		boolean[] visited = new boolean[graph.length];
		int[] minDistances = new int[graph.length];
		for(int i = 0; i < minDistances.length; i ++) minDistances[i] = INF;
		minDistances[start] = 0;
		nodeStack.push(start);
		distStack.push(0);
		while(!nodeStack.isEmpty()) {
			int currentNode = nodeStack.pop();
			int currentDist = distStack.pop();
			if(visited[currentNode] && minDistances[currentNode] <= currentDist) continue;
			visited[currentNode] = true;
			minDistances[currentNode] = currentDist;
			for(int i = 0; i < graph.length; i ++) {
				if(graph[currentNode][i] != INF) {
					nodeStack.push(i);
					distStack.push(currentDist + graph[currentNode][i]);
				}
			}
		}
		return minDistances;
	}        
    }

    
    
    public static void getDiameters(){
        System.out.println("\n Diameter of Social Networks"); 
        // scanning from the input user  
        try (Scanner sc = new Scanner(System.in)){
            int N = sc.nextInt();
            // a tree for a case
            ArrayList<Network> networks = new ArrayList<>();
            // reading all cases
            for(int n = 0; n < N; n++){
                int nodes = sc.nextInt(); // nodes of the network
                int connections = sc.nextInt(); // number of connection of the network
                int[][] net = new int[nodes][nodes];
                for(int i=0; i<net.length; i++)
                    for(int j=0; j<net.length; j++)
                        net[i][j] = INF;
                // insert nodes in a temporary list
                for(int i = 0; i < connections; i++){
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    net[x-1][y-1] = 1; // Connection x to y
                    net[y-1][x-1] = 1; // Connection y to x
                }
                // create the tree for each case
                networks.add(new Network(net)); 
            }
            // Print each tree
            System.out.println("\n Output");
            for(int n = 0; n < N; n++){
                Network net = networks.get(n);
                int d = net.getDiameter();
                System.out.println("" + d);
            }
            System.out.println("");
        }
        
    }
    
    public static void main(String[] args){
        getDiameters();
    }
    
}
