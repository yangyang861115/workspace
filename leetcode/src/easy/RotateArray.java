package easy;
/*
 * 189
 * Rotate Array
 * Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Hint:
Could you do it in-place with O(1) extra space?
Related problem: Reverse Words in a String II
 * */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] ans = new int [n];
        for(int i = 0; i < (n - k); i++) {
            ans[i + k] = nums[i];
        }
        for(int i = 0; i < k; i++) {
            ans[i] = nums[i + n - k];
        }
        for(int i = 0; i < n; i++) {
            nums[i] = ans[i];
        }
    }
    
    //smart way
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    
    public void reverse(int[]nums, int i, int j) {
        while(i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
