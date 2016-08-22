package medium;
/*
 * 136. Single Number
 * Given an array of integers, every element appears twice except for one. 
 * Find that single one.
 * Your algorithm should have a linear runtime complexity. 
 * Could you implement it without using extra memory?
 * 
 * */
public class SingleNumber {
    public int singleNumber(int[] A) {
        int n = A.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum = sum ^ A[i];
        }
        return sum;
    }
}
