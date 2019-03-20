import java.util.HashMap;
import java.util.Stack;

class Solution20 {
    
    private HashMap<Character, Character> mappings;
    public Solution20() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put( ')', '(' );
        this.mappings.put( '}', '{' );
        this.mappings.put( ']', '[' );
    }
    
    public boolean isValid(String s) {
        if (s.isEmpty()) return true;

        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            if(this.mappings.containsKey(currentChar)) {
                char topElement = (stack.isEmpty()) ? '#' : stack.pop();
                if(topElement != this.mappings.get(currentChar)) return false;
            } else {
                stack.push(currentChar);
            }
        }
        return stack.isEmpty();
    }
    
}