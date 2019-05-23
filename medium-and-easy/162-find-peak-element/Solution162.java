class Solution162 {
    public int findPeakElement(int[] nums) {
        if(nums.length == 0 && nums.length == 1) return 0;
        
        return binarySearch(nums,0,nums.length-1);
    }
    
    public int binarySearch(int[] nums,  int left, int right) {
        int mid = (left+right) /2;
        if(isPeak(nums, mid)) return mid;
        
        //mid is on an ascending slope
        if(mid+1 < nums.length && nums[mid] < nums[mid+1] ){
            return binarySearch(nums, mid+1, right);
        } else {
            return binarySearch(nums,left, mid-1);
        }
        
        
        
    }
    
    public boolean isPeak(int[] nums, int i) {
        return (i-1 < 0 || nums[i-1] < nums[i]) && (i+1 >= nums.length || nums[i] > nums[i+1]);
    }
}