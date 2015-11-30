package week6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class TwoSum2 {
    final static int SIZE = 1000000;
    final static int RANGE_HIGH = 10000;
    final static int RANGE_LOW = -10000;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Long[] numbers = new Long[SIZE];
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
        List<Long> list = Arrays.asList(numbers);
        Collections.sort(list);
        
        
        Set<Long> setT = new HashSet<Long>();
        int i = 0;
        int j = SIZE - 1;
        
        while( i < j) {
            long x = list.get(i);
            long y = list.get(j); 
            if (x + y > RANGE_HIGH) {
                j--;
            }else if (x + y < RANGE_LOW) {
                i++;
            }else {           
                setT.add(x + y);
                //x stay still, move y left
                
                int k = j;
                while (list.get(k) + x >= RANGE_LOW) {
                    setT.add(x + list.get(k));                    
                    k--;
                }
                k = i;
                while (list.get(k) + y <= RANGE_HIGH) {
                    setT.add(y + list.get(k));                   
                    k++;
                }
                //y stay still, move x right
                i--;
                j--;
                
            }
        }
        
        
        
        System.out.println(setT.size());
       
    }
    

}
