package easy;

import java.util.*;

/*
 * 217
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.*/
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums) {
            if(set.contains(num)) return true;
            else {
                set.add(num);
            }
        }
        return false;
    }
//    public static void main(String args[]) {
//        Integer[] nums = {1, 2, 3, 3};
//        
//        Set<Integer> set = new HashSet<Integer>(Arrays.asList(nums));
//        System.out.print(set.size());
//    }
}
