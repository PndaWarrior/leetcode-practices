class Solution75 {
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void sortColors(int[] nums) {
        
        int l = -1,
        r = nums.length,
        i = 0;
        
        while(i < r) {
            
            if(nums[i] == 0) {
                swap(nums, ++l, i);
                ++i;
            } else if(nums[i] == 2) {
                swap(nums, --r, i);
            } else  {
                ++i;
            }
        }
            
        
        for(int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println("");
    }
}