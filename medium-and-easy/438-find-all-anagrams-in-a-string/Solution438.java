import java.util.ArrayList;
import java.util.List;

class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<Integer>();
        
        if (s.length() < p.length()) return answer;
        
        int[] dictionary = new int[26];
        
        for (int i = 0; i < p.length(); i++) {
            dictionary[p.charAt(i) - 'a']++;
            dictionary[s.charAt(i) - 'a']--;
        }
        
        int lettersMatched = 0;
        
        for (int i = 0; i < dictionary.length; i++) {
            if(dictionary[i] == 0) lettersMatched++;
        }
        
        if (lettersMatched == 26) {
            answer.add(0);
        }
        
        for (int i = 0; i < s.length() - p.length(); i++) {
            
            int charL = s.charAt(i) - 'a';
            int charR = s.charAt(i + p.length()) - 'a';
            
            dictionary[charR]--;
            if (dictionary[charR] == 0) {
               lettersMatched++; 
            } else if (dictionary[charR] == -1) {
                lettersMatched--;
            }
            
            dictionary[charL]++;
            if (dictionary[charL] == 0) {
                lettersMatched++;
            } else if (dictionary[charL] == 1) {
                lettersMatched--;
            }
            
            if(lettersMatched == 26) {
                answer.add(i+1);
            }
            
            
        }
        
        
        return answer;
        
        
        
    }
}