package Assignment1.com;

import java.util.*;

public class Graph {
    HashMap<Integer, ArrayList<Integer>> adj;
    int vertices;

    public Graph(int vertices) {
        this.vertices = vertices;
        adj = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            adj.put(i, new ArrayList<>());
        }
    }
    public void addEdge(int v1, int v2) {
        adj.get(v1).add(v2);
        adj.get(v2).add(v1);
    }
    public void bfs(int v){
            HashSet<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.add(v);
            visited.add(v);
            while (!queue.isEmpty()){
                int curr = queue.poll();
                System.out.print(curr + " ");
                for(int i : adj.get(curr)){
                    if(!visited.contains(i)){
                        visited.add(i);
                        queue.add(i);
                    }
                }
            }
    }
}
