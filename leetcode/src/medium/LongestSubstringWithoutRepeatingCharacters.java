package medium;

import java.util.*;

/*
 * 3
 * Given a string, find the length of the longest substring without repeating characters.
Examples:
Given "abcabcbb", the answer is "abc", which the length is 3.
Given "bbbbb", the answer is "b", with the length of 1.
Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring2(String s) {
        if(s.isEmpty()) return 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLength = 0;
        for(int i = 0, j = 0; i < n; i++) {
            if(map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
        
    }
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        
        int n = s.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLength = 0;
        int start = 0;
        map.put(s.charAt(0), 0);
        
        for(int i = 1; i < n; i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map.size() > maxLength) maxLength = map.size();
                
                if(s.charAt(i) == s.charAt(start)) {
                    start++;
                    map.put(s.charAt(i), i);
                } else{
                    start = map.get(s.charAt(i)) + 1;
                    map = new HashMap<Character, Integer>();
                    i = start - 1;
                }
            }else {
                map.put(s.charAt(i) , i);
            }
        }
        if(map.size() > maxLength) maxLength = map.size();
        
        return maxLength;
    }
}
