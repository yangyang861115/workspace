package lab5;

public class Lab5 {
        
    public void insert (double value, int index, Node B[]) {
        Node t = new Node(value);
        if (B[index] == null) {
            B[index] = t;
        }else{
            Node p0 = B[index];
            Node p1 = p0.next;
            while(p1 != null) {
                if(p1.d >= value) {
                    break;                  
                }
                p1 = p1.next;
                p0 = p0.next;
            }
            
            
            if(p0.d > value) {
                B[index] = t;
                t.next = p0;
            }else{
                p0.next = t;
                t.next = p1;
            }
                       
        }
    }
    
    public double[] bucketSort(double A[]) {
        int n = A.length;
        double C[] = new double[n];
        Node[] B = new Node[100];
        for(int i = 0; i < n; i++) {
            int index = (int) (Math.floor(n * A[i]));
            insert (A[i], index, B);
        }
        int j = 0;
        for (int i = 0; i < 100; i++) {
            if(B[i] != null) {
                Node s = B[i];
                while(s != null) {
                    C[j] = s.d;
                    s = s.next;
                    j++;
                }
            }
        }        
        return C;
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Lab5 lab = new Lab5();
        int n = 20;
        double[] A = new double[n];
        System.out.println("The array is ");
        for(int i = 0; i < n; i++) {
            A[i] = Math.random();
            System.out.println(A[i] + " ");
        }
        System.out.println();
        System.out.println("-----------------");
        double[] C = lab.bucketSort(A);
        for(int i = 0; i < n; i++) {
            System.out.println(C[i] + " ");
        }
        
    }

}
