package lab2;

public class Sort {
    /****
     * Bubble Sort 
     * @param integer array A
     *            
     */
    public void bubbleSort(int A[]) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int tmp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = tmp;
                }
            }
        }
    }

    /*****
     * Insert Sort
     * @param A
     */
    public void insertSort(int A[]) {
        for (int i = 1; i < A.length; i++) {
            int hold = A[i];
            int j = i - 1;
            for (; j >= 0 && A[j] > hold; j--) {
                A[j + 1] = A[j];
            }
            A[j + 1] = hold;
        }
    }

    /***
     * Merge Sort
     * @param A
     */
    public void mergeSort (int A[], int begin, int end) {
        int mid = 0;
        if (begin < end) {
            mid = (begin + end) / 2;
            mergeSort(A, begin, mid);
            mergeSort(A, mid + 1, end);
            merge(A, begin, mid, end);
        }
    }
    /***
     * merge two part of an array into one sorted array
     * @param A 
     * @return
     */
    public void merge(int A[], int begin, int mid, int end) {
        int i = begin, j = mid + 1;
        int tmpArray[] = new int[end - begin + 1];
        int k = 0;
        while(i <= mid && j<= end) {
            if(A[i] <= A[j]) {
                tmpArray[k] = A[i];
                i++;
            }else {
                tmpArray[k] = A[j];
                j++;
            }
            k++;
        }
        while(i <= mid) {
            tmpArray[k] = A[i];
            i++;
            k++;
        }
        while(j <= end ) {
            tmpArray[k] = A[j];
            j++;
            k++;
        }
        i = begin;
        for (int n: tmpArray) {
            A[i] = n;
            i++;
        }
    }
    
    public String toString(int A[]) {
        String ans = "[";
        for (int num : A) {
            ans += (num + " ");
        }
        ans += "]";
        return ans;
    }
    
    public int[] copy(int A[]){
        int[] B = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            B[i] = A[i];
        }
        return B;
    }

    public static void main(String[] args) {

        int A[] = { 2, 3, 1, 0, 7, 9, -1, 4, 0, 6 , -9};
        Sort s = new Sort();
        int B[] = s.copy(A);
        s.bubbleSort(B);
        System.out.println("Bubble Sort");
        System.out.println(s.toString(B));
        
        B = s.copy(A);
        s.insertSort(B);
        System.out.println("Insert Sort");
        System.out.println(s.toString(B));
        
        B = s.copy(A);
        s.mergeSort(B, 0, B.length - 1);
        System.out.println("Merge Sort");
        System.out.println(s.toString(B));
    }

}
