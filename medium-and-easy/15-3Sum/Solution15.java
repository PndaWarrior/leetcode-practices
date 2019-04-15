import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution15 {
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        print(nums);
        
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) return answer;
        
        for(int i = 0; i < nums.length - 2 ; i++) {
            
            
            if(i > 0 && nums[i] == nums[i-1]) continue;
            
            int target = 0 - nums[i];
            int l = i +1;
            int r = nums.length - 1;
            
            
            while(l<r) {
                if(nums[l] + nums[r] == target) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    answer.add(temp);
                    ++l;
                    --r;
                    while(l < r && nums[l] == nums[l-1]) 
                        ++l;
                    while(l < r && nums[r] == nums[r+1]) 
                        --r;
                } else if(nums[l] + nums[r] > target) {
                    --r;
                } else {
                    ++l;
                }
            }
            
        }
        
        return answer;
        
    }
    
    public void print(int[] nums) {
        System.out.print("[");
        for(int i = 0; i < nums.length; i++) {
            System.out.print(" " + nums[i]);
        }
        System.out.print(" ]");
        System.out.println("");
    }
}