package week2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Comparisons {
    static long comparisons = 0;
    public static void quickSort1(int array[], int left, int right) {
        if (left >= right) {
            return;
        }
        comparisons += (right - left);
        int pivot = array[left];
        int i = left + 1;
        int j;
        int tmp;
        for (j = left + 1; j <= right; j++) {
            // if array[j] > pivot, do nothing
            if (array[j] < pivot) {
                // swap a[j] and a[i]
                tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;
                i++;
            }
        }
        // swap pivot and a[i - 1]
        array[left] = array[i - 1];
        array[i - 1] = pivot;
        quickSort3(array, left, i - 2);
        quickSort3(array, i, right);
    }
    
    public static void quickSort2(int array[], int left, int right) {
        //swap the last with the first
        if (left >= right) {
            return;
        }
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
        quickSort1(array, left, right);
    }

    public static void quickSort3(int array[], int left, int right) {
        if (left >= right) {
            return;
        }
        
        int pivot1 = array[left];
        
        int pivot2 = array[right];
        int pivot3 = array[(right + left) / 2];
        int pivot =  (pivot1 + pivot2 + pivot3) - 
                Math.min(Math.min(pivot1, pivot2), pivot3) - 
                Math.max(Math.max(pivot1, pivot2), pivot3);
        
        if (pivot == pivot1){
            quickSort1(array, left, right);
        } else if(pivot == pivot2){
            quickSort2(array, left, right);
        } else{
            //swap pivot3 with left element
            array[left] = pivot3;
            array[(right + left) / 2] = pivot1;
            quickSort1(array, left, right);
        }
    }
    public static void main(String[] args) {
        int[] numbers = new int[10000];
        // read the numbers from file
        FileInputStream fstream = null;
        BufferedReader br = null;
        String strLine;
        try {
            // Open the file
            fstream = new FileInputStream("src/week2/QuickSort.txt");
            br = new BufferedReader(new InputStreamReader(fstream));
            try {
                int i = 0;
                while ((strLine = br.readLine()) != null) {
                    numbers[i] = Integer.parseInt(strLine);
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

        //
        System.out.println(comparisons);
        quickSort3(numbers, 0, numbers.length - 1);
        System.out.println(comparisons);
//        for(int i = 0; i < 10000; i++){
//            System.out.println(numbers[i]);
//        }
    }

}
