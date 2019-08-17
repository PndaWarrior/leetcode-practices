import java.util.HashMap;
import java.util.Map;

class Solution567WithHashMap {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length() || s2.length() == 0) return false;
        if(s1.length() == 0) return true;
        
        Map<Character, Integer> targetMap = new HashMap<Character, Integer>();
        Map<Character, Integer> sourceMap = new HashMap<Character, Integer>();
        
        
        for (int i = 0; i < s1.length(); i++) {
            targetMap.compute(s1.charAt(i), (k,v) -> (v == null) ? 1 : v+1);
            sourceMap.compute(s2.charAt(i), (k,v) -> (v == null) ? 1 : v+1);
        }
        
        for (int j = s1.length(); j < s2.length(); j++) {
            if (targetMap.equals(sourceMap)) return true;
            
            char l = s2.charAt(j-s1.length());
            char r = s2.charAt(j);
            
            sourceMap.compute(r, (k,v) -> (v == null) ? 1 : v+1);
            sourceMap.compute(l, (k,v) -> (v - 1));
            
            if(sourceMap.get(l) == 0) sourceMap.remove(l);
            r++;
            l++;
            
        }
        
        
        
        return sourceMap.equals(targetMap);
        
    }

}