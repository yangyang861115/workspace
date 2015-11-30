package week1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountInversion {
    static long inversions = 0;
    public static void mergeSort(int array[]) {
        int[] tmpArray = new int[array.length];
        mergeSort(array, tmpArray, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] tmpArray, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, tmpArray, left, middle);
            mergeSort(array, tmpArray, middle + 1, right);
            merge(array, tmpArray, left, middle + 1, right);
        }

    }

    private static void merge(int[] array, int[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (array[leftPos] < array[rightPos]) {
                tmpArray[tmpPos] = array[leftPos];
                tmpPos++;
                leftPos++;
            } else {
                tmpArray[tmpPos] = array[rightPos];
                inversions += (leftEnd - leftPos + 1);
                tmpPos++;
                rightPos++;
            }
        }
        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = array[leftPos++];
        }
        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = array[rightPos++];
        }
        // Copy TmpArray back
        for (int i = 0; i < numElements; i++, rightEnd--) {
          array[rightEnd] = tmpArray[rightEnd];
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[100000];
        // read the numbers from file
        FileInputStream fstream = null;
        BufferedReader br = null;
        String strLine;
        try {
            // Open the file
            fstream = new FileInputStream("src/week1/IntegerArray.txt");
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
        
        System.out.println(inversions);
        mergeSort(numbers);
        System.out.println(inversions);
        
    }
    
 
}
