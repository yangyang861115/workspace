package easy;
import java.util.Arrays;
/*
 * 242
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] dict = new int[26];
       
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        for(char c: s1) {
            dict[c - 'a']++;
        }
        //System.out.println(Arrays.toString(dict));
        for(char c : t1) {
            dict[c- 'a']--;
            if(dict[c -'a'] < 0) return false;
        }
        return true;
    }
}
