package week6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class median {

    public static void main(String[] args) {
        final int SIZE = 10000;
        FileInputStream fstream = null;
        BufferedReader br = null;
        String strLine;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1, new MyComparator());

        try {
            // Open the file
            fstream = new FileInputStream("src/week6/Median.txt");
            List<Integer> temp = new ArrayList<Integer>();
            br = new BufferedReader(new InputStreamReader(fstream));
            try {
                long total = 0;
                int median = 0;
                while ((strLine = br.readLine()) != null) {
                    int number = Integer.parseInt(strLine);
                    temp.add(number);
                    maxHeap.add(number);
                    if (minHeap.size() > 0) {
                        while (maxHeap.peek() > minHeap.peek()) {
                            minHeap.add(maxHeap.poll());
                            maxHeap.add(minHeap.poll());
                        }
                    }
                    
                    if (maxHeap.size() - minHeap.size() == 2) {
                        minHeap.add(maxHeap.poll());                        
                    }
                    median = maxHeap.peek();
                    
                    total = (total + median) % 10000;
//                    System.out.println(median + " ");
//                    Collections.sort(temp);
//                    System.out.println(temp);
                }
                
                    System.out.println(total);
                    
                
                // Close the input stream
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}

class MyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        // TODO Auto-generated method stub
        return (int) (o2 - o1);
    }

}
