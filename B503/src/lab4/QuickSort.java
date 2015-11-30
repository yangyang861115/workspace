package lab4;

import java.util.Scanner;

public class QuickSort {
    
    public int partition(int A[], int left, int right){
        int pivot = A[right];
        int i = left -1;
        for(int j = left; j <= right - 1; j++) {
            if (A[j] <= pivot) {
                i++;
                swap(A, i, j);
            }
        }
        swap(A, i + 1, right);
        return i + 1;
    }
    
    public void swap(int A[], int i, int j) {
        if (i == j) return;
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    public void quickSort(int A[], int l, int r) {
        if(l < r) {
            int p = partition(A, l, r);
            quickSort(A, l, p - 1);
            quickSort(A, p + 1, r);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        System.out.println("Please give me an input size n: ");
        int n = Integer.parseInt(input.next());
        System.out.println("please input numbers: ");
        int A[] = new int[n];
        for(int i =0; i < n; i++){
                A[i] = Integer.parseInt(input.next());
        }

        QuickSort q = new QuickSort();
        q.quickSort(A, 0, A.length - 1);
        for (int i : A) {
            System.out.print(i + " ");
        }
    }

}
