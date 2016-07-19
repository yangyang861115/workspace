package easy;

/*
 * 70
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 * 
 * */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n <= 2 && n >= 0) return n;
        int answer[] = new int[n + 1];
        answer[1] = 1;
        answer[2] = 2;
        for (int i = 3; i <= n; i++) {
            answer[i] = answer[i - 1] + answer[i - 2];
        }

        return answer[n];
    }
}
