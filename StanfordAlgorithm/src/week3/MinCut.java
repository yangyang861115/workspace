package week3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MinCut {
    public static int contraction(List<List<Integer>> graphOrg){   
        int verticesNum =  graphOrg.size();
        List<List<Integer>> graph = new ArrayList<List<Integer>>(verticesNum); 
        for (List<Integer> list : graphOrg) {
            //graph.add((ArrayList<Integer>) list.clone());
            List<Integer> newList = new ArrayList<Integer>(list);
            graph.add(newList);
        }
        
//         Iterator<List<Integer>> iter = graphOrg.iterator();
//         while (iter.hasNext()) {
//             List<Integer> list = iter.next();
//             List<Integer> newList = new ArrayList<Integer>(list);
//             graph.add(newList);
//         }
         
        int totalNum = verticesNum;
        int minCut = verticesNum -1;
        
        while(totalNum > 2){
                   
            int uIndex = (int) (Math.random() * verticesNum);
            int u = uIndex + 1;
            while(graph.get(uIndex).size() == 0) {
                uIndex = (int) (Math.random() * verticesNum);
                u = uIndex + 1;
            }
            List edges = graph.get(uIndex);
        
            int randEdgeIndex = (int) (Math.random() * edges.size());
            int v = (int) edges.get(randEdgeIndex);
            int vIndex = v -1;
            while(v == u) {
                randEdgeIndex = (int) (Math.random() * edges.size());
                v = (int) edges.get(randEdgeIndex);
                vIndex = v -1;
            }
        
            //System.out.println("u= " + u + " v= " + v);
            //make all the edges in u connected to vertex v
            for (Object vertex : edges){
                int w = (int)vertex;
                if(w != v && w != u) {
                    for(int k = 0; k < graph.get(w - 1).size(); k++) {
                        if (graph.get(w - 1).get(k) == u) {
                            graph.get(w - 1).set(k, v); 
                        }
                    }
                }
                          
            }
            //add all the edges in u to v
            graph.get(vIndex).addAll(edges);
            //remove self connected v and u
            for(int k = 0; k < graph.get(vIndex).size(); k++) {
                if(graph.get(vIndex).get(k) == u){
                    graph.get(vIndex).remove(k);
                    k--;
                    
                }
                else if(graph.get(vIndex).get(k) == v){
                    graph.get(vIndex).remove(k);
                    k--;
                }
            }            
            //clean the edges in u
            graph.set(uIndex, new ArrayList());
            totalNum--;
        }
        for (int i = 0; i < verticesNum; i++) {
            int size = graph.get(i).size();
            if ( size!= 0 && size < minCut) {
                minCut = size;
            }
        }
        return minCut;
    }
    
    
    public static void main(String[] args) { 
        int vertices = 200;
        List<List<Integer>> graph = new ArrayList<List<Integer>>(vertices);
        // read the numbers from file
        FileInputStream fstream = null;
        BufferedReader br = null;
        String strLine;
        try {
            // Open the file
            fstream = new FileInputStream("src/week3/kargerMinCut.txt");
            br = new BufferedReader(new InputStreamReader(fstream));
            try {
                int i = 0;
                while ((strLine = br.readLine()) != null) {
                    
                    graph.add(new ArrayList());
                    String edges[] = strLine.split("\\s");
                    for (int j = 1; j < edges.length; j++) {
                        graph.get(i).add(Integer.parseInt(edges[j]));
                        
                    }                  
                    i++;
                }
                // Close the input stream
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        int minCut = vertices - 1; 
        for (int i = 0; i <  vertices; i++ ){
            int num = contraction(graph);
            if (num < minCut) minCut = num;
        }
        System.out.println(minCut);
    }

}
