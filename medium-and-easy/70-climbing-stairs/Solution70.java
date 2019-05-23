import java.util.Arrays;

class Solution70 {
    public int climbStairs(int n) {
        if(n <= 0) return 0;
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        int[] steps = {1, 2};
        
        return calculateSteps(n, dp, steps);
    }
    
    public int calculateSteps(int n, int[] dp, int[] steps) {
        if(dp[n] != -1) return dp[n];
        if (n == 1) {
            dp[n] = 1;
        } else if (n == 2) {
            dp[n] = 2;
        } else {
            dp[n] = calculateSteps(n-1, dp, steps) + calculateSteps(n-2, dp, steps);  
        }
        
        return dp[n];
    }
}