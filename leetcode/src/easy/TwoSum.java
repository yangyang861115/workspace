package easy;

import java.util.*;

/*
 * 1
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
    Example:
    Given nums = [2, 7, 11, 15], target = 9,
    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
    The return format had been changed to zero-based indices. Please read the above updated description carefully.
 * */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int result[] = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i++){
            if(map.containsKey((target - nums[i]))) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
            }else {
                map.put(nums[i], i);
            }
        }
        
        return result;   
    }
}
