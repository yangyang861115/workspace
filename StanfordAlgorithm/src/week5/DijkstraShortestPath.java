package week5;

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

public class DijkstraShortestPath {
    
    
    public static int[] dijkstra(int graph[][], int sNode) {
        int size = graph.length;
        int[] A = new int [size];
        for (int i = 0; i < size; i++) {
            A[i] = Integer.MAX_VALUE;
        }
        A[sNode - 1] = 0;
        
        Set X = new HashSet();
        X.add(sNode);
//        Set Y = new HashSet();
//        for (int i = 1 ; i != sNode && i <= size; i++ ) {
//            Y.add(i);
//        }
        
        
        while (X.size() != size) {
            int mindist = Integer.MAX_VALUE;
            int minNode = -1;
            for(Object node : X) {
                int nodeV = (Integer)node;
                int nodeW = -1;
                int VW = 1000000;
                for (int i = 0; i < size; i++) {
                    // nodeW is connected to nodeV
                    if( !X.contains(i + 1) && graph[nodeV - 1][i] < VW) {
                        VW = graph[nodeV - 1][i];
                        nodeW = i + 1;
                    }
                }
                if (mindist > A[nodeV - 1] + VW) {
                    mindist = A[nodeV - 1] + VW;
                    minNode = nodeW;
                }
            }
            
            X.add(minNode); 
            A[minNode - 1] = mindist;
            
        }
        
        
        //PriorityQueue heap = new PriorityQueue();
        
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
        // for (int i = 0; i < 10; i++) {
        // for (int j = 0; j < 10; j++) {
        // System.out.print(graph[i][j] + " ");
        // }
        // System.out.println();
        // }
        int[] score = dijkstra(graph, 1);
//        for (int i = 0; i < vertices; i++) {
//            System.out.print(score[i] + " ");
//        }
        int[] tests = {7,37,59,82,99,115,133,165,188,197};
        for(int i : tests) {
            System.out.print(score[i - 1]+",");
        }
        
    }

}
