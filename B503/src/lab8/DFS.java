package lab8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFS {

    public void dfs(Map<Integer, ArrayList<Integer>> graph, int[] visited, int u) {
        if (visited[u] == 0) {
            visited[u] = 1;
            ArrayList<Integer> neighbor = graph.get(u);
            if (neighbor != null) {
                for (int i : neighbor) {
                    dfs(graph, visited, i);
                }
            }
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Edge[] listOfEdges = { new Edge(0, 1), new Edge(1, 2), new Edge(2, 3), new Edge(1, 3), new Edge(7, 6),
                new Edge(6, 8), new Edge(8, 9), new Edge(9, 6), new Edge(5, 4), new Edge(4, 3) };
        Map<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();

        for (Edge e : listOfEdges) {
            int u = e.u;
            int v = e.v;
            if (graph.get(u) != null) {
                graph.get(u).add(v);
            } else {
                graph.put(u, new ArrayList());
                graph.get(u).add(v);
            }
            
            if (graph.get(v) != null) {
                graph.get(v).add(u);
            } else {
                graph.put(v, new ArrayList());
                graph.get(v).add(u);
            }
        }
        System.out.println(graph);
        int visited[] = new int[100];
        DFS test = new DFS();
        
        int s = 0;
        int e = 3;
        test.dfs(graph, visited, s);
        System.out.println(visited[e]);
    }

}

class Edge {
    int u;
    int v;

    public Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }
}
