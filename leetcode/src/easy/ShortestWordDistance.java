package easy;
/*
 * 243
 * Shortest Word Distance
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.
 * */
public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int min = words.length;
        for (int i = 0, j = -1, k = -1; i < words.length; i++) {
            if (words[i].equals(word1)) {
                j = i;
                if (k != -1 && j - k < min ) {
                    min = j - k;
                }
            } else if (words[i].equals(word2)) {
                k = i;
                if (j != -1 && k - j < min) {
                    min = k - j;
                }
            }
        }
        return min;
    }
}
