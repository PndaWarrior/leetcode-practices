import java.util.ArrayList;
import java.util.List;

class Solution301 {
    
    
    public List<String> removeInvalidParentheses(String s) {
        
        List<String> answer = new ArrayList<String>();
        
        //First I want to calculate out how many left and rightparathese I need to remove
        int l = 0,
        r = 0,
        len = s.length();
        
        for (int i = 0; i < len; i++) {
            if ( s.charAt(i) == '(' ) {
                l++;
            }
            else if ( s.charAt(i) == ')') {
                if( l == 0) r++;
                else l--;
            } 

        }
        
        dfs(s, len, 0, 0, l, r, answer, new StringBuilder());
        
        return answer;
    }
    
    //balance is used for checking if I have balanced parantheses in my current stringbuilder
    public void dfs(String s, int len, int start, int balance, int l, int r, List<String> answer, StringBuilder builder) {
        
        //This loop will check all characters and see if it should be part of the result set
        for (int i = start; i < len; i++) {
            
            //If balance < 0, that means there's a close bracket at the front, we can disregard this case completely
            if ( balance < 0 ) return;
            
            char currentChar = s.charAt(i);
            
            //Skip repeating characters, because i only need to remove teh first one, if there's multiple opening or closing brackets that needs to be removed in a row, it would be taken care of by the next iteraion of the recursion
            
            if ( i == start || currentChar != s.charAt(i-1) ){
                
                //Removing Closeing before removing Open
                if ( r > 0  && currentChar == ')') {
                    
                    int currBuilderLength = builder.length();
                    //This is a "remove", we pass in the currently built stringbuilder, and move forward one index, so this current character will not be considered in further calculation;
                    dfs(s, len, i + 1, balance, l, r - 1, answer, builder);
                    
                    //Because we recursively passed down the builder to use for building out further cases, we need to reset back to the current state to loop through the rest of the loop.
                    builder.setLength(currBuilderLength);
                    
                } else if ( l > 0 && currentChar == '(' ){
                    
                    //Repeat same process for 
                    int currBuilderLength = builder.length();
                    dfs(s, len, i + 1, balance, l - 1, r, answer, builder);
                    builder.setLength(currBuilderLength);
                    
                }
                
            }
            
                
            //Append the current character so when we continue the loop, we go on as if this parathese has been included
            builder.append(currentChar);

            // update the balance
            if (currentChar == '(') ++balance;
            if (currentChar == ')') --balance;
            
        }
        
            
        // add string to final result list
        if (l == 0 && r == 0 && balance == 0) answer.add(builder.toString());
            
        
    }
    
}