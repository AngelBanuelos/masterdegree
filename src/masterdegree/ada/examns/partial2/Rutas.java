package masterdegree.ada.examns.partial2;

import java.util.Arrays;
import java.util.Stack;

public class Rutas {

    public static void main(String[] args) {
        int[][] mapa = {{0, 25, 28, 0, 0, 0, 0},
        {0, 0, 33, 35, 0, 0, 0},
        {0, 0, 0, 0, 56, 0, 56},
        {0, 0, 0, 0, 0, 61, 23},
        {0, 0, 0, 0, 30, 0, 56},
        {0, 0, 0, 50, 0, 0, 0},
        {0, 0, 0, 0, 0, 39, 0}};
        int INF = 0;
//        int[][] mapa = {
//            {INF, 20, 15, INF},
//            {20, INF, INF, 10},
//            {15, INF, INF, 25},
//            {INF, 10, 25, INF}
//        };
        int N = 4; //numero de turistas que puede llevar el camion mas peque�o
        int turistas = 12; //numero de turistas a pasear
        int start = 0;   //indice de la ciudad inicial
        int end = 3; //indice de la ciudad final
        ExistsRoute(mapa, N, turistas, start, end);
    }

    static void ExistsRoute(int[][] graph, int N, int T, int initial, int destination) {
        Stack<Integer> nodeStack = new Stack<Integer>();
        Stack<Integer> distStack = new Stack<Integer>();
        boolean[] visited = new boolean[graph.length];
        int[] minDistances = new int[graph.length];
        for (int i = 0; i < minDistances.length; i++) {
            minDistances[i] = 0;
        }
        minDistances[initial] = 0;
        nodeStack.push(initial);
        distStack.push(0);
        while (!nodeStack.isEmpty()) {
            int currentNode = nodeStack.pop();
            int currentDist = distStack.pop();
            if (!visited[currentNode]) {
                visited[currentNode] = true;
                minDistances[currentNode] = currentDist;
                for (int i = 0; i < graph.length; i++) {
                    if (graph[currentNode][i] != 0 && graph[currentNode][i] >= T && graph[currentNode][i] >= N) {
                        nodeStack.push(i);
                        distStack.push(currentDist + graph[currentNode][i]);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(minDistances));
        if (minDistances[destination] != 0) {
            System.out.println("verdadero");
        } else {
            System.out.println("falso");
        }
    }
}
