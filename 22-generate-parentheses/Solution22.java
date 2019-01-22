import java.util.ArrayList;
import java.util.List;

class Solution22 {
    List<String> answer = new ArrayList<String>();
    
    
    public List<String> generateParenthesis(int n) {
        
        loadValidParenthesis(n, n, "");
        
        return answer;
        
    }
    
    public void loadValidParenthesis(int numLBracket, int numRBracket, String currentString) {
        
        if(numLBracket > 0 ) {
            
            loadValidParenthesis(numLBracket-1, numRBracket, currentString + "(");
            

        }            
        if (numRBracket > 0 && numRBracket > numLBracket){
              loadValidParenthesis(numLBracket, numRBracket-1, currentString + ")");  
        }
        
        if (numLBracket == 0 && numRBracket == 0){
            answer.add(currentString);
        }
        
        
    }
    
}