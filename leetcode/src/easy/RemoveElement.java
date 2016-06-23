package easy;

import java.util.Arrays;

/*
 * 27
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * Example:Given input array nums = [3,2,2,3], val = 3
 * Your function should return length = 2, with the first two elements of nums being 2.
 * */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int m = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] != val) {
                nums[m] = nums[i];
                m++;
            }    
        }
        System.out.println(Arrays.toString(nums));
        return m;
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RemoveElement re = new RemoveElement();
        System.out.println(re.removeElement(new int[] { 3, 5, 3 }, 5));
        

    }

}
