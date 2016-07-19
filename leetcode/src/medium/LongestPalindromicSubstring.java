package medium;
/*
 * 5
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * 
 * every time we move to right, we only need to consider 
 * whether using this new character as tail could produce new palindrome 
 * string of length (current length +1) or (current length +2)
 * "aa", "aca"
 * 
 * */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int longestlength = 0;
        int n = s.length();
        String res = "";
        for(int i = 0; i < n; i++) {
            System.out.println("i = " + i);
            if(isPalindrom(s, i - longestlength - 1, i)) {
                res = s.substring(i - longestlength - 1, i + 1);
                System.out.println(res);
                longestlength += 2;
            } else if(isPalindrom(s, i - longestlength, i)){
                res = s.substring(i - longestlength, i + 1);
                System.out.println(res);
                longestlength += 1;
            }
        }
        return res;
    }
    
    public boolean isPalindrom(String s, int start, int end){
        if(start < 0) return false;
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) return false; 
        }
        return true;
    }
}
