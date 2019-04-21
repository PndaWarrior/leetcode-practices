import java.util.Random;

class Solution215 {
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int partition(int[] nums, int l, int r, int p) {
        swap(nums, r, p);
        
        int i = l-1;
        int pivot = nums[r];
        for(int j = l; j <= r; j++) {
            
            if(nums[j] >= pivot) {
                ++i;
                swap(nums, i, j);
            }
        }
        
        return i;
    }
    
    public int quickSelect(int[] nums, int l, int r, int k) {
        if(l == r) return l;
        // select a random pivot_index
        Random random_num = new Random();
        //this will select a random number after l before r
        int pivot_index = l + random_num.nextInt(r - l); 
        
        int i = partition(nums, l, r, pivot_index);
        
        
        if(i == k) {
            return i;
        } else if( i < k) {
            return quickSelect(nums, i+1, r, k);
        } else {
            return quickSelect(nums, l, i-1, k);
        }
        
    }
    
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0 ) return 0;
        if(nums.length == 1) return nums[0];
        return nums[quickSelect(nums, 0, nums.length-1, k-1)];
        
    }
}