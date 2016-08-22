package medium;
/*
 * 260 Single Number III
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * */
public class SingleNumberIII {
    //naive way should use hashset
    public int[] singleNumber(int[] nums) {
        int total = 0;
        int[] ans = new int[2];
        for(int num : nums) {
            total = (total ^ num);
        }
        
        total &= -total;
        
        for(int num : nums){
            if((total & num) == 0) {
                ans[0] =  (ans[0] ^ num);
            }else {
                 ans[1] = (ans[1] ^ num);
             }
        }
        return ans;
    }
}
