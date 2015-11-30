package lab3;

public class HeapSort {
    
    public void max_heapify(int A[], int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < n && A[left] > A[i]) 
            largest = left;
        if (right < n && A[right] > A[largest])
            largest = right;
        if (largest != i) {
            //swap A[i] and A[largest]
            int tmp = A[i];
            A[i] = A[largest];
            A[largest] = tmp;
            max_heapify(A, largest, n);
        }
    }
    
    public void bulid_max_heap(int A[]) {
        int size = A.length;
        for(int i = size / 2; i >= 0; i--) {
            max_heapify(A, i, size);
        }
    }
    
    public void heapSort(int A[]) {
        bulid_max_heap(A);
        int n = A.length;
        for(int i = n - 1; i >= 1; i--) {
            int tmp = A[i];
            A[i] = A[0];
            A[0] = tmp;
            n--;
            max_heapify(A, 0, n);
        }
    }
    
    public String toString(int A[]) {
        String ans = "[";
        for(int num : A) {
            ans += (num + ", ");
        }
        ans += "]";
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5}; 
        HeapSort s = new HeapSort();
        System.out.println("Original array is" + s.toString(A));
        s.bulid_max_heap(A);
        System.out.println("Buliding a heap...");
        System.out.println(s.toString(A));
        System.out.println();
        
        int B[] = {7, 9, 2, 4, 8, 1}; 
        System.out.println("Original array is" + s.toString(B));
        System.out.println("Heap sort...");
        s.heapSort(B);
        System.out.println(s.toString(B));
    }

}
