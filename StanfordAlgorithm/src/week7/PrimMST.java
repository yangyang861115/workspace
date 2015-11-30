package week7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class PrimMST {
    public static long mst(int vertices, ArrayList<List<Edge>> list) {
        long total = 0;
        int A[] = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            A[i] = Integer.MAX_VALUE;
        }
        
        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        A[0] = 0;
        PriorityQueue<Edge> heap = new PriorityQueue<Edge>();
        for (Edge e : list.get(0)) {           
            heap.add(e);          
            A[e.node - 1] = e.weight;
        }
        while (set.size() != vertices) {
            
            Edge chosen = heap.poll();
//            System.out.println(chosen);
//            
//            System.out.println(set);
//            System.out.println("---------");
            while (set.contains(chosen.node)) {
                chosen = heap.poll();
            }
//            System.out.println(chosen);
            int w = chosen.weight;
            int n = chosen.node;
            set.add(n);
            
            //System.out.println(set);
            A[n - 1] = w;
            for (Edge change : list.get(n - 1)) {
                if ((!set.contains(change.node)) && A[change.node - 1] > change.weight) {
                    A[change.node - 1] = change.weight;
                                                          
                    heap.add(change);                  
                } 
            }
            
        }

        for (int i : A)
            total += i;
        return total;
    }

    public static void main(String[] args) {
        int vertices = 0;
        int edges = 0;
        List<List<Edge>> list = new ArrayList<List<Edge>>();
        FileInputStream fstream = null;
        BufferedReader br = null;
        String strLine;
        try {
            // Open the file
            fstream = new FileInputStream("src/week7/edges.txt");
            br = new BufferedReader(new InputStreamReader(fstream));
            try {
                String[] record = br.readLine().split(" ");
                vertices = Integer.parseInt(record[0]);
                edges = Integer.parseInt(record[1]);
                for (int i = 0; i < vertices; i++) {
                    list.add(new ArrayList<Edge>());
                }
                while ((strLine = br.readLine()) != null) {
                    record = strLine.split(" ");
                    int s = Integer.parseInt(record[0]);
                    int e = Integer.parseInt(record[1]);
                    int weight = Integer.parseInt(record[2]);
                    list.get(s - 1).add(new Edge(e, weight));
                    list.get(e - 1).add(new Edge(s, weight));

                }
                // Close the input stream
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // System.out.println(vertices);
        // System.out.println(edges);
        // System.out.println(list.get(0));
        long ans = mst(vertices, (ArrayList<List<Edge>>) list);
        System.out.println(ans);
    }

}

class Edge implements Comparable {
    int node;
    int weight;

    public Edge(int n, int w) {
        node = n;
        weight = w;
    }

    public String toString() {
        return ("[" + node + " " + weight + "]");

    }

    @Override
    public int compareTo(Object o) {
        return this.weight - ((Edge) o).weight;
    }
}
