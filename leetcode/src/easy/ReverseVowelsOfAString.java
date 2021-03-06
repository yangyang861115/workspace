package easy;
/*
 * 345
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * Example 1: Given s = "hello", return "holle".
 * Example 2: Given s = "leetcode", return "leotcede".
 * 
 * */
public class ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        char[] words = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int n = words.length;
        for(int i = 0, j = n - 1; i < j; ){
            char c1 = words[i];
            char c2 = words[j];
            if(vowels.indexOf(c1) != -1 && vowels.indexOf(c2) != -1) {
                //swap
                words[i] = c2;
                words[j] = c1;
                i++;
                j--;
            } else if(vowels.indexOf(c1) != -1) {
                j--;
            } else {
                i++;
            }
        }
        return new String(words);
    }
}
