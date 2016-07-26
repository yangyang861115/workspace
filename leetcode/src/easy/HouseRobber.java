package easy;

/*
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them is 
 * that adjacent houses have security system connected and it will 
 * automatically contact the police if two adjacent houses were broken 
 * into on the same night.
 * Given a list of non-negative integers representing the amount of 
 * money of each house, determine the maximum amount of money you can 
 * rob tonight without alerting the police.
 * 
 * */
public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] money = new int[n];
       
        money[0] = nums[0];
        money[1] = Math.max(money[0], nums[1]);
        
        for (int i = 2; i < n; i++) {
            money[i] = Math.max(nums[i] + money[i - 2], money[i - 1]);
        }
        return money[n - 1];

    }
    
    public int rob2(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[][] dp = new int[n][2];
        dp[0][1] = nums[0];
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i] + dp[i - 1][0];
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
    
    public int rob3(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        
        int twostep = 0;
        int onestep = nums[0];
        int money = onestep;
        for(int i = 2; i <= n; i++) {
            money = Math.max(twostep + nums[i - 1], onestep);
            twostep = onestep;
            onestep = money;
        }
        return money;
    }
}
