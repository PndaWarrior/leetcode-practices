import java.util.ArrayList;
import java.util.List;

class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>((int) Math.pow(nums.length, 2));
        result.add(new ArrayList<Integer>());
        
        for( int i = 0; i < nums.length; i++) {
            
            int currentSize = result.size();
            
            for( int j = 0; j < currentSize; j++) {
                
                List<Integer> current = new ArrayList<Integer>(result.get(j));
                current.add(nums[i]);
                result.add(current);
                
            }
            
        }
        
        return result;
        
    }
}