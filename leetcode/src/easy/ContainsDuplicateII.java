package easy;
import java.util.*;
/*
 * 219
 * Given an array of integers and an integer k, 
 * find out whether there are two distinct indices i and j 
 * in the array such that nums[i] = nums[j] and 
 * the difference between i and j is at most k.
 * */
public class ContainsDuplicateII {
    //too slow
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < n ; i++) {
            if(map.containsKey(nums[i])) {
                int j = map.get(nums[i]);
                if(i - j <= k) return true;
                else {
                    map.put(nums[i], i);
                }
            }else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
    
    //sliding window
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < n; i++) {
            if(i > k) set.remove(nums[i - k - 1]);
            if(!set.add(nums[i])) return true;
            
        }
        return false;
    }
   
}
