/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.graph;

import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author angel_banuelos
 */
public class Session8 {

    static boolean deepFirstSearch(boolean[][] graph, HashMap<String, Integer> map,
            String start, String end) {

        Stack<Integer> pending = new Stack();
        pending.push(map.get(start));
        boolean[] visited = new boolean[graph.length];
        while (!pending.isEmpty()) {
            int current = pending.pop();
            if (current == map.get(end)) {
                return true;
            }
            int currentIndex = map.get(current);
            for (int i = 0; i < graph.length; i++) {
                visited[current] = true;
                if (graph[currentIndex][i] && !visited[i]) {
                    pending.push(i);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E", "F", "G"};
        boolean t = true, f = false;
        boolean[][] graph = {{f, t, t, f, f, f, f}};

        HashMap<String, Integer> map = new HashMap();
        for (int i = 0; i < names.length; i++) {
            map.put(names[i], i);
        }

    }

}
