package easy;

import java.util.*;

/*
 * 170
 * Two Sum III - Data structure design 
 * Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
Show Company Tags
Show Tags
Show Similar Problems

 * */
public class TwoSumIII_DataStructureDesign {

}

class MyTwoSum {

    // Add the number to an internal data structure.
    private Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
    private List<Integer> list = new ArrayList<Integer>();
    public void add(int number) {
        list.add(number);
        if(!map.containsKey(number)) {
            map.put(number, 1);
        }else {
            map.put(number, map.get(number) + 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        Set<Integer> keys = map.keySet();
        for(int k: list) {
            if((k * 2 == value && map.get(k) >= 2) || (k * 2 != value && map.containsKey(value - k)))return true;
        }
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
