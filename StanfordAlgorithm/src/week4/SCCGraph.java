package week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class SCCGraph {
    
    
    public static void main(String[] args) {
        int vertices = 875714;
        List<List<Integer>> graph = new ArrayList<List<Integer>>(vertices);
        List<List<Integer>> graphRev = new ArrayList<List<Integer>>(vertices);
        // read the numbers from file
        FileInputStream fstream = null;
        BufferedReader br = null;
        String strLine;
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList());
            graphRev.add(new ArrayList());
        }
        try {
            // Open the file
            fstream = new FileInputStream("src/week4/SCC.txt");
            br = new BufferedReader(new InputStreamReader(fstream));
            try {

                while ((strLine = br.readLine()) != null) {
                    String edges[] = strLine.split("\\s");
                    int node1 = Integer.parseInt(edges[0]);
                    int node2 = Integer.parseInt(edges[1]);
                    graph.get(node1 - 1).add(node2);
                    graphRev.get(node2 - 1).add(node1);
                }
                // Close the input stream
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        
        int[] order1 = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            order1[i] = vertices - i; 
        }
        int finishTime[] = DFS.DFS_Loop(graphRev, order1);
        
        int[] order2 = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            order2[vertices - finishTime[i]] = i + 1; 
        }
        DFS.DFS_Loop(graph, order2);
        
        //DFS.DFS_Loop(graph);
//        for (int i = 0; i < 9; i++) {
//            System.out.print(time[i] + " ");
//        }
        // // write to file graph.txt
        // Writer writer = null;
        // try {
        // writer = new BufferedWriter(new OutputStreamWriter(
        // new FileOutputStream("src/week4/graph.txt"), "utf-8"));
        // for (int i = 0; i < 875714; i++) {
        // //System.out.println(graph.get(i));
        // for(int node : graph.get(i)) {
        // writer.write(node + "\t");
        // }
        // writer.write("\n");
        // }
        //
        // } catch (IOException e) {
        // e.printStackTrace();
        // } finally {
        // try {writer.close();} catch (Exception ex) {/*ignore*/}
        // }

    }

}
