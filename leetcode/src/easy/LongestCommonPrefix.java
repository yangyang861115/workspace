package easy;

/*
 * 14
 * Write a function to find the longest common prefix string amongst an array of strings.
 * ["ab", "a", "abc"] ---> "a"
 * ["", "a", "ab"] ----> ""
 * */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 0)
            return "";
        String ans = strs[0];
        for (int i = 1; i < n; i++) {
            String cur = strs[i];

            int len = Math.min(ans.length(), cur.length());
            String tmp = "";
            for (int j = 0; j < len; j++) {
                if (ans.charAt(j) != cur.charAt(j)) {
                    tmp = ans.substring(0, j);
                    break;
                } else {
                    tmp = ans.substring(0, j + 1);
                }
            }
            ans = tmp;

        }

        return ans;
    }
}
