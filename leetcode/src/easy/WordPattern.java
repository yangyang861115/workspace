package easy;
import java.util.*;

/*
 * 290
 * Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Examples:
 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.
 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 * 
 * */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        char[] patternArray = pattern.toCharArray();
        String[] wordsArray = str.split(" ");
        System.out.println(Arrays.toString(patternArray));
        System.out.println(Arrays.toString(wordsArray));
        if (patternArray.length != wordsArray.length)
            return false;

        Map<Character, String> map = new HashMap<Character, String>();
        Map<String, Character> map2 = new HashMap<String, Character>();
        for (int i = 0; i < patternArray.length; i++) {
            char c = patternArray[i];
            String word = wordsArray[i];
            if (!map.containsKey(c))
                map.put(c, word);
            if (map.containsKey(c) && !map.get(c).equals(word))
                return false;

            if (!map2.containsKey(word))
                map2.put(word, c);
            if (map2.containsKey(word) && map2.get(word) != c)
                return false;
        }

        return true;
    }
}
