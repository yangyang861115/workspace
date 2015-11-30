package week6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    final static int SIZE = 1000000;
    final static int RANGE_HIGH = 10000;
    final static int RANGE_LOW = -10000;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        long[] numbers = new long[SIZE];
        FileInputStream fstream = null;
        BufferedReader br = null;
        String strLine;
        try {
            // Open the file
            fstream = new FileInputStream("src/week6/algo1-programming_prob-2sum.txt");
            br = new BufferedReader(new InputStreamReader(fstream));
            try {
                int i = 0;
                while ((strLine = br.readLine()) != null) {
                    numbers[i] = Long.parseLong(strLine);
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
        //System.out.println(numbers[1000000 -1]);
        Set<Long> set = new HashSet<Long>();
        Set<Integer> setT = new HashSet<Integer>();
        //Your task is to compute the number of target values t in the interval 
        //[-10000,10000] (inclusive)
        //long t =500;
        
        for (int i = 0; i < SIZE; i++) {
            if (i % 10000 == 0) System.out.println(i);
            for (long t = RANGE_LOW; t <= RANGE_HIGH; t++ ) {
                long x = numbers[i];            
                long y = t - x;            
                if (set.contains(y)) setT.add((int)t);
                    //System.out.println(x + " " + y + "=" + t);
                set.add(x);
            }
        }
        System.out.println(setT.size());
       
    }
    

}
