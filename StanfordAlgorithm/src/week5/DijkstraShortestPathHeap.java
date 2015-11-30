package week5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstraShortestPathHeap {
    
    
    public static int[] dijkstraHeap(int graph[][], int sNode) {
        int size = graph.length;
        int[] A = new int [size];
        for (int i = 0; i < size; i++) {
            A[i] = Integer.MAX_VALUE;
        }
        A[sNode - 1] = 0;
        
        Set X = new HashSet();
        X.add(sNode);
        Set Y = new HashSet();
        for (int i = 1 ; i != sNode && i <= size; i++ ) {
            Y.add(i);
        }
        //make a heap for Edge(node, key)
        PriorityQueue<Edge> heap = new PriorityQueue<Edge>();
        heap.add(new Edge(0, sNode));
//        Map keys = new HashMap();
//        for (int i = 0; i < size; i++) {
//            keys.put(i + 1, Integer.MAX_VALUE);
//        }
//        keys.put(sNode, 0);
        for (Object w : Y) {
            int nodeW = (Integer)w;
            int key = Integer.MAX_VALUE;
            for (Object v : X) {
                int nodeV = (Integer)v;
                if (graph[nodeV - 1][nodeW - 1] != 1000000) {
                    if (A[nodeV - 1] + graph[nodeV - 1][nodeW - 1] < key) {
                        key = A[nodeV - 1] + graph[nodeV - 1][nodeW - 1];                       
                    }
                }
            }
            Edge e = new Edge(key, nodeW); 
            //keys.put(nodeW, key);
            A[nodeW - 1] = key;
            heap.add(e);
        }
        System.out.println(heap);
        while (X.size() != size) {
            Edge minEdge = (Edge)heap.poll();
            int minNode = minEdge.node;
            int mindist = minEdge.key;
            
            X.add(minNode); 
            Y.remove(minNode);
            A[minNode - 1] = mindist;
//            for(int i = 0; i < size; i++ ) {
//                if (A[minNode - 1] + graph[minNode - 1][i] < (int)keys.get(i + 1)) {
//                    keys.remove(i + 1);
//                    keys.put(i + 1, A[minNode - 1] + graph[minNode - 1][i]);
//                   
//                    heap.add(new Edge(A[minNode - 1] + graph[minNode - 1][i], i + 1));
//                }               
//            }
            
            for(int i = 0; i < size; i++ ) {
                if (A[minNode - 1] + graph[minNode - 1][i] < A[i]) {
                    //keys.remove(i + 1);
                    //keys.put(i + 1, A[minNode - 1] + graph[minNode - 1][i]);
                    A[i] = A[minNode - 1] + graph[minNode - 1][i];
                    heap.add(new Edge(A[minNode - 1] + graph[minNode - 1][i], i + 1));
                }               
            }
            
        }
                
        
        return A;
    }

    public static void main(String[] args) {
        int vertices = 200;
        int[][] graph = new int[vertices][vertices]; 
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                graph[i][j] = 1000000;
            }
        }
        // read the numbers from file
        FileInputStream fstream = null;
        BufferedReader br = null;
        String strLine;
        try {
            // Open the file
            fstream = new FileInputStream("src/week5/dijkstraData.txt");
            br = new BufferedReader(new InputStreamReader(fstream));
            try {
                
                while ((strLine = br.readLine()) != null) {                   
                    String line[] = strLine.split("\\s");                    
                    int sNode = Integer.parseInt(line[0]);
                    int eNode;
                    int distance;
                    for (int i = 1; i < line.length; i++) {
                        String[] info = line[i].split(",");
                        eNode = Integer.parseInt(info[0]);
                        distance = Integer.parseInt(info[1]);
                        graph[sNode - 1][eNode - 1] = distance;
                    }
                    
                }
                // Close the input stream
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        
        int[] score = dijkstraHeap(graph, 1);
//        for (int i = 0; i < vertices; i++) {
//            System.out.print(score[i] + " ");
//        }
        int[] tests = {7,37,59,82,99,115,133,165,188,197};
        for(int i : tests) {
            System.out.print(score[i - 1]+",");
        }
        
    }

}

class Edge implements Comparable{
    public int node;    
    public int key;
    
    public Edge ( int key, int node) {
        this.node = node;
        this.key = key;
    }

    @Override
    public int compareTo(Object o) {
        Edge edge2 = (Edge)o;
        return this.key - edge2.key;
        
    }

}
