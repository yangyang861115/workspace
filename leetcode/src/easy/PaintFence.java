package easy;

/*
 * 276 
 * Paint Fence
 * There is a fence with n posts, each post can be painted with one of the k colors.

 You have to paint all the posts such that no more than two adjacent fence posts have the same color.

 Return the total number of ways you can paint the fence.

 Note:
 n and k are non-negative integers.
 * */
public class PaintFence {
    public int numWays(int n, int k) {
        if (n == 0)
            return 0;
        int[][] ans = new int[n + 1][2];
        ans[1][0] = k; // not equal to previous color
        ans[1][1] = 0; // equal to previous color

        for (int i = 2; i <= n; i++) {
            ans[i][0] = (ans[i - 1][0] + ans[i - 1][1]) * (k - 1);
            ans[i][1] = ans[i - 1][0];
        }
        return ans[n][0] + ans[n][1];
    }
}
