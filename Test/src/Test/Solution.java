package Test;


    
    
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            while (n > 1) {
                count += n % 2;
                n = n / 2;
            }
            if (n == 1) count += 1;
            return count;
        }
        
        public static void main(String[] args) {
            // TODO Auto-generated method stub

        }
    }
    
    

