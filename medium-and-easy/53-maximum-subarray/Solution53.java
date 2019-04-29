class Solution53 {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        int[] dp = new int[2];
        
        int answer = nums[0];
        dp[0] = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            
            dp[i%2] = Math.max(nums[i], dp[(i-1)%2] + nums[i]);
            answer = Math.max(answer, dp[i%2]);
        }
        
        return answer;
    }
}