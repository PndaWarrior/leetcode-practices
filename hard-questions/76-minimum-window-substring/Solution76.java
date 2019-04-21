import java.util.HashMap;
import java.util.Map;

class Solution76 {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) return "";
        
        Map<Character, Integer> tCount = new HashMap<Character, Integer>();
        for(int i = 0; i < t.length(); i ++) {
            char c = t.charAt(i);
            int count = tCount.getOrDefault(c, 0);
            tCount.put(c, count+1);
        }
        
        Map<Character, Integer> windowCount = new HashMap<Character, Integer>();
        
        int i = 0,
        j = 0,
        answerLength = Integer.MAX_VALUE,
        requiredCharacters = tCount.size(),
        formedCharacters = 0;
        
        String answer = "";
        
        while(j < s.length()) {
            char cj = s.charAt(j);
            int currentCount = windowCount.getOrDefault(cj, 0);
            windowCount.put(cj, currentCount + 1);
            

            if(tCount.containsKey(cj) && tCount.get(cj).equals(windowCount.get(cj))) {
                formedCharacters++;
            }
            
            while(formedCharacters == requiredCharacters && i <= j) {
                if(j-i+1 < answerLength) {
                    answerLength = j-i+1;
                    answer = s.substring(i, j+1);
                }
                
                char ci = s.charAt(i);
                windowCount.put(ci, windowCount.get(ci) -1);
                
                if(tCount.containsKey(ci) && tCount.get(ci) > windowCount.get(ci)) --formedCharacters;
                
                ++i;
                
            }
            
            ++j;
            
        }
        
        return answer;
        
    }
}