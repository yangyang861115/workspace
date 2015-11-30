package week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFS {
    public static int time = 0;

    public static int souceVertex;

    public static void DFS(List<List<Integer>> graph, int node, boolean exployed[], int leader[], int finishTime[]) {

        // mark node as explored
        exployed[node - 1] = true;
        // set leader(i) = souceVertex
        leader[node - 1] = souceVertex;
        for (Integer arc : graph.get(node - 1)) {
            if (!exployed[arc - 1]) {
                DFS(graph, arc, exployed, leader, finishTime);
            }
        }

        time++;
        finishTime[node - 1] = time;
    }

    public static int[] DFS_Loop(List<List<Integer>> graph, int order[]) {
        int vertices = graph.size();

        int finishTime[] = new int[vertices];
        int leader[] = new int[vertices];
        boolean exployed[] = new boolean[vertices];
        for (int i : order) {
            if (!exployed[i - 1]) {
                souceVertex = i;
                DFS(graph, i, exployed, leader, finishTime);
            }
        }
        System.out.println();
        // for (int i = 0; i < vertices; i++){
        // System.out.print(leader[i] + " ");
        // }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < vertices; i++) {
            Integer count = map.get(leader[i]);
            if (count == null) {
                count = 0;
            }
            map.put(leader[i], count + 1);
        }
        List<Integer> result = new ArrayList<Integer>(map.values());
        Collections.sort(result);
        // System.out.println(result);
        for (int j = result.size() - 1; j > result.size() - 6; j--) {
            System.out.print(result.get(j) + " ");
        }

        return finishTime;
    }

}
