class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int temp = 1;
        int answer = 1;
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]){
                temp ++;
            } else {
                temp = 1;
            }
            answer = Math.max(answer, temp);
        }
        
        return answer;
        
    }
}