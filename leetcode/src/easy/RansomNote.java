package easy;

import java.util.*;

/*
 * 383
 * Ransom Note
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 * Note:You may assume that both strings contain only lowercase letters.
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * 
 * */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> dict = new HashMap<Character, Integer>();
        int n = ransomNote.length();
        int m = magazine.length();
        if(n > m) return false;
        
        for(int i = 0; i < m; i++) {
           char letter = magazine.charAt(i);
           if(dict.containsKey(letter)){
               dict.put(letter, dict.get(letter) + 1);
           } else {
               dict.put(letter, 1);
           }
        }
        for(int i = 0; i < n; i++) {
            char letter = ransomNote.charAt(i);
            if(dict.containsKey(letter)) {
                dict.put(letter, dict.get(letter) - 1);
                if(dict.get(letter) < 0) return false;
            } else {
                return false;
            }
        }
        
        return true;
        
    }
}
