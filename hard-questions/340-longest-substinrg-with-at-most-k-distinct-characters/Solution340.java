import java.util.HashMap;
import java.util.Map;

class Solution340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length() == 0 || k == 0) return 0;
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        int i = 0,
        j = 0,
        answer = 0;
        
        while(j < s.length()) {
            char cj = s.charAt(j);
            int count = map.getOrDefault(cj, 0);
            map.put(cj, count + 1);
            
            if(map.size() <= k) {
                answer = Math.max(answer, j-i+1);
            }
            
            while(map.size() > k) {
                char ci = s.charAt(i);
                int ciCount = map.get(ci);
                if(ciCount == 1) {
                    map.remove(ci);
                } else {
                    map.put(ci, ciCount-1);
                }
                i++;
            }
            
            j++;
            
        }
        
        return answer;
    }
}