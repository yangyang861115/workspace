package easy;

/*
 * 266
 * Palindrome Permutation 
 * Given a string, determine if a permutation of the string could form a palindrome.
 For example,
 "code" -> False, "aab" -> True, "carerac" -> True.
 * */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        int[] dict = new int[128];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = (int) s.charAt(i);
            dict[num]++;
        }
        for (int i = 0; i < 128; i++) {
            if (dict[i] % 2 == 1)
                count++;
            if (count >= 2)
                return false;
        }
        return true;

    }
}
