class SolutionDP410 {

    int[] accumSum;
    int[][] dp;

    public int splitArray(int[] nums, int m) {
        int n = nums.length;

        dp = new int[n + 1][m + 1];
        accumSum = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i  = 0; i < n; i++ ) {
            accumSum[i + 1] = accumSum[i] + nums[i];
        }

        dp[0][0] = 0;


        return calcMinLargestSubarray(dp, n, m);
    }

    public int calcMinLargestSubarray(int[][] dp, int k, int m) {
        if (dp[k][m] != Integer.MAX_VALUE) {
            return dp[k][m];
        } else if (m == 1) {
            dp[k][m] = accumSum[k];
            return dp[k][m];
        } else if ( m > k ) {
            return Integer.MAX_VALUE;
        } else {

            for (int i = 1; i < k; i++) {
                dp[k][m] = Math.min(dp[k][m],
                    Math.max(calcMinLargestSubarray(dp, i, m-1), accumSum[k] - accumSum[i]));
            }
            return dp[k][m];
        }
    }
}
