import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution17 {
    
    HashMap<String, String> lettersMap = new HashMap<String, String>();
    List<String> answer = new ArrayList<String>();
    public Solution17() {
        lettersMap.put("2", "abc");
        lettersMap.put("3", "def");
        lettersMap.put("4", "ghi");
        lettersMap.put("5", "jkl");
        lettersMap.put("6", "mno");
        lettersMap.put("7", "pqrs");
        lettersMap.put("8", "tuv");
        lettersMap.put("9", "wxyz");
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() != 0) {
            getNextCombination("", digits, 0);
        }
        return answer;
    }
    
    public void getNextCombination(String currentCombo, String digits, int index) {
        if(index >= digits.length()) {
            answer.add(currentCombo);
        }
        else {
            
            String currentDigit = digits.substring(index, index+1);
            String letters = lettersMap.get(currentDigit);
            int i = 0;
            while(i < letters.length()) {
                getNextCombination(currentCombo + letters.substring(i, i+1), digits, index+1);
                i++;
            }
        }
    }
}