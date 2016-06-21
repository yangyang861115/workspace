package easy;
import java.util.Arrays;
/*
 * 283
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 * */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        while(i < n) {
            if(nums[i] != 0) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                j++;
            }
            i++;
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MoveZeroes mz = new MoveZeroes();
        int[] array = new int[]{0, 1, 2, 0, 0, 3};
        mz.moveZeroes(array);
        System.out.println(Arrays.toString(array));
    }

}
