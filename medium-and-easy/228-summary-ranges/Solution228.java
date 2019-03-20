import java.util.ArrayList;
import java.util.List;

class Solution228 {
    
    public List<String> summaryRanges(int[] nums) {
        List<String> answer = new ArrayList<String>();
        
        if(nums.length == 0) return answer;
        
        int startRange = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[i-1] != 1) {
                String temp = (startRange == nums[i-1]) ? Integer.toString(startRange) : Integer.toString(startRange) + "->" + Integer.toString(nums[i-1]);
                answer.add(temp);
                startRange = nums[i];
            }
        }
        String temp = (startRange == nums[nums.length-1])? Integer.toString(startRange) : Integer.toString(startRange) + "->" + Integer.toString(nums[nums.length-1]);
        
        answer.add(temp);
        
        return answer;
        
    }
}