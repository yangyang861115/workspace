package easy;

import java.util.*;

/*
 * 118
 * Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 * */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> level;

        for (int i = 0; i < numRows; i++) {
            level = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    level.add(1);
                else {
                    int num = ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j);
                    level.add(num);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}
