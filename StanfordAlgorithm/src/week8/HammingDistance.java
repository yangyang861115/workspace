package week8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HammingDistance {
    /*
     * change one or two bits in the input string return an array of strings of
     * size total
     */
    public static String[] permutation(String number, int size) {
        int total = size + size * (size - 1) / 2;
        String[] p = new String[total];

        int n = 0;
        for (int i = 0; i < size && n < total; i++) {
            String newString = number.substring(0, i) + ('1' - number.charAt(i)) + number.substring(i + 1);
            p[n] = newString;
            n++;
            for (int j = i + 1; j < size && n < total; j++) {
                newString = number.substring(0, i) + ('1' - number.charAt(i)) + number.substring(i + 1, j)
                        + ('1' - number.charAt(j)) + number.substring(j + 1);
                p[n] = newString;
                n++;
            }
        }

        return p;
    }
    /*
     * find the leader of a node return the leader node
     */
    public static String findLeader(Map<String, String> map, String s) {
        String p = map.get(s);
        while (p != s) {
            s = p;
            p = map.get(s);
        }
        return p;
    }

    /*
     * union two nodes into one cluster if they are in different cluster return
     * true if the union is success
     */
    public static boolean union(Map<String, String> map, String s1, String s2, Map<String, Integer> rank) {
        String leader1 = findLeader(map, s1);
        String leader2 = findLeader(map, s2);
        if (!leader1.equals(leader2)) {
            if (rank.get(leader1) <= rank.get(leader2)) {
                map.put(leader1, leader2);
                if (rank.get(leader1) == rank.get(leader2)) {
                    int val = rank.get(leader2);
                    rank.put(leader2, val + 1);
                }
            } else {
                map.put(leader2, leader1);
            }
            return true;
        } else {
            return false;
        }

    }

    /*
     * 
     * 
     * 
     */
    public static int compute(Set<String> set, String[] numbers, int vertices, int size) {
        Map<String, String> map = new HashMap<String, String>();
        Map<String, Integer> rank = new HashMap<String, Integer>();
        Set<String> ans = new HashSet<String>();
        for(String s : numbers) {
            map.put(s, s);
            rank.put(s, 0);
        }
        
        
        for (String s : numbers) {
            String[] p = permutation(s, size);
            for (String per : p) {
                if (set.contains(per)) {
                    union(map, s, per, rank);                   
                }
            }
        }
        
        for (String key : map.keySet()) {
            String leader = findLeader(map, key); 
            if (!ans.contains(leader)) {
                ans.add(leader);
            }
        }
        
        return ans.size();
        
    }

    public static void main(String[] args) {
        int vertices = 0;
        int size = 0;
        String[] numbers = null;
        Set<String> set = new HashSet<String>();
        // read the numbers from file
        FileInputStream fstream = null;
        BufferedReader br = null;
        String strLine;

        try {
            // Open the file
            fstream = new FileInputStream("src/week8/clustering_big.txt");
            br = new BufferedReader(new InputStreamReader(fstream));
            try {
                String[] record = br.readLine().split(" ");
                vertices = Integer.parseInt(record[0]);
                size = Integer.parseInt(record[1]);
                numbers = new String[vertices];
                int i = 0;
                while ((strLine = br.readLine()) != null) {
                    String number = "";
                    record = strLine.split(" ");
                    for (String c : record) {
                        number += c;
                    }
                    numbers[i] = number;
                    set.add(number);
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
        System.out.println(vertices + " " + size);
        System.out.println(compute(set, numbers, vertices, size));
        // System.out.println(numbers[0]);
        // System.out.println(permutation (numbers[0], size)[1]);
    }

}
