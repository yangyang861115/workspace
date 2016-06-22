package easy;

import java.util.*;

/*
 * 350
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * */
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (int num : nums2) {
            if(map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        
        int[] answerArray = new int[list.size()];
        int i = 0;
        for(int num : list) {
            answerArray[i] = num;
            i++;
        } 
        return answerArray;

    }

    public static void main(String[] args) {
        IntersectionOfTwoArraysII intersection = new IntersectionOfTwoArraysII();
        int[] num1  = new int[]{1, 2, 2, 1};
        int[] num2  = new int[]{2, 2, 1};
        int[] ans = intersection.intersect(num1, num2);
        System.out.println(Arrays.toString(ans));
            

    }

}
