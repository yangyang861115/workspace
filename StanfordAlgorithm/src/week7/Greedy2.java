package week7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Greedy2 {

    public static void main(String[] args) {
        int numbers = 0;
        int[] weight = null;
        int[] length = null; 
        // read the numbers from file
        FileInputStream fstream = null;
        BufferedReader br = null;
        String strLine;
        try {
            // Open the file
            fstream = new FileInputStream("src/week7/jobs.txt");
            br = new BufferedReader(new InputStreamReader(fstream));
            try {
                strLine = br.readLine();
                numbers = Integer.parseInt(strLine);
                int i = 0;
                String[] record;
                weight = new int[numbers];
                length = new int[numbers];
                while ((strLine = br.readLine()) != null) {
                    record = strLine.split(" ");
                    weight[i] = Integer.parseInt(record[0]);
                    length[i] = Integer.parseInt(record[1]);
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

        System.out.println(compute1 (numbers, weight, length));

    }
    
    public static long compute1 (int number, int[] weight, int[] length) {
        long total = 0;
                
        List<Job2> list = new ArrayList<Job2>();
                
        for (int i = 0; i < number; i++) {
            list.add(new Job2(weight[i], length[i]));
        }
        Collections.sort(list);
        int l = 0;
        int w = 0;
        for (int i = 0; i < number; i++) {
            w = list.get(i).weight;
            l += list.get(i).length;
            total += w * l;
        }
        return total;
    }

}

class Job2 implements Comparable{
    int weight;
    int length;
    double rate;
    public Job2 (int weight, int length) {
        this.weight = weight;
        this.length = length;
        this.rate  = 1.0 * weight / length;
    }
    @Override
    public int compareTo(Object o) {   
        if (((Job2)o).rate - this.rate > 0) return 1;
        else if(((Job2)o).rate - this.rate < 0) return -1;
        else return 0;
        
        
    }
}
