package easy;

import java.util.Arrays;

/*
 * 26
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 * */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int m = 0;
        if(n <= 0) return m;
         
        int current = nums[0];
        for(int i = 1; i < n; i++) {
            if(nums[i] != current){
                m++;
                nums[m] = nums[i];
                current = nums[m];
            } 
        }
        System.out.println(Arrays.toString(nums));
        return m + 1;
        
        
//        if (A.length==0) return 0;
//        int j=0;
//        for (int i=0; i<A.length; i++)
//            if (A[i]!=A[j]) A[++j]=A[i];
//        return ++j;
    }
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray rd = new RemoveDuplicatesFromSortedArray();
        System.out.println(rd.removeDuplicates(new int[]{1, 2, 2, 3}));
    }

}