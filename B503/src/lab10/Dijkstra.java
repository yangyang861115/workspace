package lab10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Dijkstra {
    static final int INF = 9999999;
    
    public static void main(String[] args) {
       
        int n = 5;
        int m = 10;
        Edge[] edges = {new Edge(0, 1, 10), new Edge(0, 3, 5),
                        new Edge(1, 2, 1), new Edge(1, 3, 2),
                        new Edge(2, 4, 4), new Edge(3, 1, 3),
                        new Edge(3, 2, 9), new Edge(3, 4, 2),
                        new Edge(4, 0, 7), new Edge(4, 2, 6)
                        };
        //generate the graph
        ArrayList<LinkedList<Node>> graph = new ArrayList<LinkedList<Node>>();
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<Node>());
        }
        for (Edge e : edges) {
            int u = e.u;
            int v = e.v;
            int w = e.cost;
            Node node = new Node(v, w); 
            graph.get(u).add(node);
            
        }
        //print the graph
        for(int i = 0; i < n; i++) {
            System.out.print(i + "===>  ");
            for(Node node: graph.get(i)) {
                System.out.print(node.vertex + "(" + node.dist + ") ");
            }
            System.out.println();
        }
        
        Comparator<Node> cmp = new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return n1.dist - n2.dist;
            }
        };
        PriorityQueue<Node> pq = new PriorityQueue<Node>(cmp);
        
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = INF;
        }
        distance[0] = 0;
        Node node = new Node(0, 0);
        pq.add(node);
        while(!pq.isEmpty()) {
            Node node_u = pq.poll();
            int u = node_u.vertex;
            int dist = node_u.dist;
            for (Node node_v: graph.get(u)){
                int v = node_v.vertex;
                int uv = node_v.dist;
                if(distance[v] > dist + uv) {
                    distance[v] = dist + uv;
                    Node newNode = new Node(v, distance[v]);
                    pq.add(newNode);
                }
                
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(distance[i]+" ");
        }
        
    }

}
class Node {
    int vertex;
    int  dist;
    public Node (int v, int d){
        vertex = v;
        dist = d;
    }
//    @Override // implements Comparable
//    public int compareTo(Object o) {
//        Node n = (Node)o; 
//        return this.dist - n.dist;
//    }
}
class Edge {
    int u;
    int v;
    int cost;

    public Edge(int u, int v, int cost) {
        this.u = u;
        this.v = v;
        this.cost = cost;
    }
}

