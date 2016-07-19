package easy;

import java.util.*;

/*
 * 349
 * Given two arrays, write a function to compute their intersection.
 * Example:Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 * */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> result = new HashSet<Integer>();
        for(int num : nums1) {
           set.add(num); 
        }
        for(int num: nums2) {
            if(set.contains(num)) result.add(num);
        }
        int[] answer = new int[result.size()];
        int i = 0;
        for(int num : result) {
            answer[i] = num;
            i++;
        }
        return answer;
    }
}
