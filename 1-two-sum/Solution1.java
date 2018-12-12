import java.util.HashMap;
import java.util.Map;

class Solution1 {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
    tempMap.put(nums[0], 0);
    for(int i = 1; i < nums.length; i ++) {
        int currentAnswer = target-nums[i];
      if(tempMap.containsKey(currentAnswer)) {
        return new int[] {tempMap.get(currentAnswer), i};
      }
        tempMap.put(nums[i], i);
    }
      return new int[] {-1,-1};
  }
}
