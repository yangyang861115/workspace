package easy;

import java.util.*;

/*
 * 119
 * Given an index k, return the kth row of the Pascal's triangle.
 For example, given k = 3,
 Return [1,3,3,1].
 * */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<Integer>();
        List<Integer> cur = new ArrayList<Integer>();

        if (rowIndex < 0)
            return cur;
        cur.add(1);
        if (rowIndex == 0)
            return cur;
        cur.add(1);
        if (rowIndex == 1)
            return cur;

        for (int i = 2; i <= rowIndex; i++) {
            pre = cur;
            cur = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    cur.add(1);
                else {
                    int num = pre.get(j) + pre.get(j - 1);
                    cur.add(num);
                }
            }
        }
        return cur;
    }

    //solution from smart person
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        if (rowIndex < 0)
            return list;

        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }
}
