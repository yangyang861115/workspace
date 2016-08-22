package medium;
/*
 * 238 Product of Array Except Self
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].
 * */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] mysum = new int[n];
        int[] mysum2 = new int[n];
        
        if(n == 0) return ans;
        mysum[0] = nums[0];
        mysum2[n - 1] = nums[n - 1];
        for(int i = 1; i < n; i++) {
            mysum[i] = mysum[i - 1] * nums[i];
        }
        for(int i = n - 2; i >= 0; i--) {
            mysum2[i] = mysum2[i + 1] * nums[i];
        }
        ans[0] = mysum2[1];
        ans[n - 1] = mysum[n - 2];
        for(int i = 1; i < n - 1; i++) {
            ans[i] = mysum[i - 1] * mysum2[i + 1];
        }
        
        return ans;
    }
}
