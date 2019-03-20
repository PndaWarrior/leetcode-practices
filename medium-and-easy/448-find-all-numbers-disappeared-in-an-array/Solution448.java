import java.util.ArrayList;
import java.util.List;

class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        int numsLength = nums.length;
        
        for(int i = 0; i < numsLength; i++) {
            int index = nums[i];
    
            while( index != 0) {
                int temp = nums[index-1];
                nums[index-1] = 0;
                index = temp;
            }
            
        }
        
        for(int i = 0; i < numsLength ; i++) {
            if(nums[i] > 0) {
                ans.add(i+1);
            }
        }
        
        return ans;
        
    }
}