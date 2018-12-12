import java.util.HashMap;
import java.util.Map;

class Solution3 {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int answer = 0;

        for (int leftWindow = 0, j = 0; j < s.length(); j++) {
            if(map.containsKey(s.charAt(j))) {
                leftWindow = (map.get(s.charAt(j))+1 > leftWindow) ? map.get(s.charAt(j)) +1 : leftWindow;
            }

            answer = (answer > (j-leftWindow+1)) ? answer : (j-leftWindow+1);
            map.put(s.charAt(j), j);
        }
        return answer;
    }
}
