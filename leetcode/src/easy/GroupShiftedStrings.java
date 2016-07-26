package easy;

import java.util.*;

/*
 * 249
 * Group Shifted Strings
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
A solution is:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
Show Company Tags
Show Tags
Show Similar Problems

 * */
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ans = new ArrayList<List<String>>();
        int flag = 1;
        for(String s : strings) {
            for(List<String> lst : ans) {
                if(compare(lst.get(0) , s)) {
                    lst.add(s);
                    flag = 0;
                    break;
                }else {
                    flag = 1;
                }
            }
            if(flag == 1) {
                List<String> mylist = new ArrayList<String>();
                mylist.add(s);
                ans.add(mylist);
            }
        }
        return ans;
    }
    
    public boolean compare(String s1 , String s2) {
        if(s1.length() != s2.length()) return false;
        int diff = (s1.charAt(0) - s2.charAt(0) + 26) % 26;
        for(int i = 1; i < s1.length(); i++) {
            if((s1.charAt(i) - s2.charAt(i) + 26) % 26 != diff) {
                return false;
            }
        }
        return true;
    }
    
    
//    public  static void main(String[] args) {
//        GroupShiftedStrings gs = new GroupShiftedStrings();
//        String[] test = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
//        System.out.println(gs.groupStrings(test).toString());
//    }
}
