class Solution152 {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        int[] min = new int[2];
        int[] max = new int[2];
        
        int answer = nums[0];
        min[0] = nums[0];
        max[0] = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            
            min[i%2] = Math.min(Math.min(nums[i], nums[i]*min[(i-1)%2]), nums[i]*max[(i-1)%2]);
            max[i%2] = Math.max(Math.max(nums[i], nums[i]*min[(i-1)%2]), nums[i]*max[(i-1)%2]);
            
            answer = Math.max(answer, max[i%2]);
        }
        return answer;
        
    }
}