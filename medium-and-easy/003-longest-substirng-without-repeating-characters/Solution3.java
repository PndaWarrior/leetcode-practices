import java.util.HashMap;
import java.util.Map;

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        int j = 0,
        answer = 0;

        for(int i = 0; i < s.length(); i++) {

            while(j < s.length() && !map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), j);
                answer = Math.max(answer, j-i+1);
                j++;
            }

            map.remove(s.charAt(i));

        }

        return answer;
    }
}
