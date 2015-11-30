package week8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Cluster {
    /*
     * find the leader of a node return the leader node
     */
    public static int findLeader(int array[], int node) {
        int p = array[node - 1];
        while (p != node) {
            node = p;
            p = array[node - 1];
        }
        return p;
    }

    /*
     * union two nodes into one cluster if they are in different cluster return
     * true if the union is success
     */
    public static boolean union(int array[], int node1, int node2, int rank[]) {
        int leader1 = findLeader(array, node1);
        int leader2 = findLeader(array, node2);
        if (leader1 != leader2) {
            if (rank[leader1 - 1] <= rank[leader2 - 1]) {
                array[leader1 - 1] = leader2;
                if (rank[leader1 - 1] == rank[leader2 - 1]) {
                    rank[leader2 - 1]++;
                }
            } else {
                array[leader2 - 1] = leader1;
            }
            return true;
        } else {
            return false;
        }

    }

    /*
     * compress all the nodes into k cluster return the maximum spacing The
     * spacing of a k-clustering is min separated p,q d(p, q)
     */
    public static int makeCluster(int k, int vertices, PriorityQueue<Edge> heap) {
        int[] nodes = new int[vertices];
        int[] rank = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            nodes[i] = i + 1;
            rank[i] = 1;
        }

        while (k < vertices) {
            Edge minEdge = heap.poll();
            int node1 = minEdge.node1;
            int node2 = minEdge.node2;
            int weight = minEdge.weight;
            if (union(nodes, node1, node2, rank)) {
                vertices--;
            }
        }
        Edge e = heap.poll();
        while (findLeader(nodes, e.node1) == findLeader(nodes, e.node2)) {
            e = heap.poll();
        }

        return e.weight;
    }

    public static void main(String[] args) {
        // List<List<Edge>> list = new ArrayList<List<Edge>>();
        PriorityQueue<Edge> heap = new PriorityQueue<Edge>();
        int vertices = 0;
        // read the numbers from file
        FileInputStream fstream = null;
        BufferedReader br = null;
        String strLine;
        try {
            // Open the file
            fstream = new FileInputStream("src/week8/clustering1.txt");
            br = new BufferedReader(new InputStreamReader(fstream));
            try {
                vertices = Integer.parseInt(br.readLine());
                // for (int i = 0; i < vertices; i++) {
                // list.add(new ArrayList<Edge>());
                // }
                while ((strLine = br.readLine()) != null) {
                    String[] record = strLine.split(" ");
                    int node1 = Integer.parseInt(record[0]);
                    int node2 = Integer.parseInt(record[1]);
                    int weight = Integer.parseInt(record[2]);
                    heap.add(new Edge(node1, node2, weight));
                    // list.get(node1 - 1).add(new Edge(node2, weight));
                    // list.get(node2 - 1).add(new Edge(node1, weight));
                }
                // Close the input stream
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(makeCluster(4, vertices, heap));
    }

}

class Edge implements Comparable {
    int node1;
    int node2;
    int weight;

    public Edge(int n1, int n2, int w) {
        node1 = n1;
        node2 = n2;
        weight = w;
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        return weight - ((Edge) o).weight;
    }

    public String toString() {
        return "[" + node1 + " " + node2 + " " + weight + "]";
    }

}
