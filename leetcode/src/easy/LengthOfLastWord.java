package easy;

/*
 * 58
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example, 
 * Given s = "Hello World",return 5.
 * */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {

        int n = s.length();
        int ans = 0;
        while (n > 0 && s.charAt(n - 1) == ' ') {
            n--;
        }

        while (n > 0 && s.charAt(n - 1) != ' ') {
            ans++;
            n--;
        }

        return ans;

    }
}
