import java.util.HashMap;

class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> cumulativeSums = new HashMap<Integer, Integer>();
        
        cumulativeSums.put(0, 1);
        
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if(cumulativeSums.containsKey(sum-k)) 
                count += cumulativeSums.get(sum-k);
            cumulativeSums.put(sum, cumulativeSums.getOrDefault(sum, 0) + 1);
            
        }
        
        return count;
        
    }
}