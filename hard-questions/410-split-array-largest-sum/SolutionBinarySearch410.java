class SolutionBinarySearch410 {
    
    public int splitArray(int[] nums, int m) {
        int high = 0;
        int low = 0;
        for (int num : nums) {
            high += num;
            if (low < num) {
                low = num;
            }
        }
        
        while(low < high) {
            
            int mid = low  + (high - low)/2;
            
            int pieces = split(nums, mid);
            
            if (pieces > m) {
                low = mid + 1;
            } else {
                high = mid;
            }
            
        }
        
        
        return low;
    }
    
    public int split(int[] nums, int mid) {
        int count = 1;
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(sum + nums[i] <= mid) {
                sum += nums[i];
            } else {
                count++;
                sum = nums[i];
            }
        }
        
        System.out.println("Count : " + count);
        System.out.println("mid = " + mid);
        
        return count;
    }
}