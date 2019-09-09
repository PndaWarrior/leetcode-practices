class Solution394 {
    public String decodeString(String s) {
        
        
        //We need to loop through the string to find the "source" repeating string expression, and merely just need to repeat it that many times.
        
        //One thing we need to take into consideration is cases when there are multiple layers of brackets, such as "3[a2[c]]".  Intuively, we can simply use recursion and DFS to help solve this problem.
        
        return dfs( s, 0, s.length() - 1);
        
        
    }
    
    
    //We need the start the index to help us keep track of our dfs level, and we need the end index because we want to make sure we take care of lower level items, but not anythin after that, for example "3[a2[c]]2[e]"  I want to build out the 3[a2[c]] part in my dfs and return it, and then at my top level, it will just continue linearly to take care of 2[e]
    public String dfs( String s, int start, int end) {
        
        //So originally I was thinking of just using the indexOf function to check for where the open and close brackets are,  but in cases of nested encode string, 3[a2[c]], it's impossible for me to know where's the digit count for the nested encode string, because the encode string could also be 3[aa2[c]] or 3[aaa2[c]]
        
        //Instead of using indexOf, we just need to simply loop through each character and if it's a digit do something, if it's a character do something else.
        
        int i = start;
        StringBuilder builder = new StringBuilder();
        
        while ( i <= end ) {
            
            
            if( isDigit(s.charAt(i))) {
                //If it is a digit, we need to start determining what's the pattern, let's get all the digits first
                
                int digitStart = i;
                while ( isDigit(s.charAt(digitStart))) {
                    digitStart++;
                    // At the end, the digitStart will end up at a '['
                }
                
                int digit = Integer.parseInt( s.substring(i, digitStart) );
                
                //Now that I have the digit, I will start to determine the pattern
                
                int patternStart = digitStart + 1;
                int counter = 1;
                
                while ( counter > 0 ) {
                    if ( s.charAt(patternStart) == '[') counter++;
                    if ( s.charAt(patternStart) == ']') counter--;
                    patternStart++;
                    
                }
                
                //At the end, I would have gotten a balanced amount of brackets, and anything in between the brackets would be the pattern that I need
                
                //digitStart ended up at 1 index over numbers, so it's an open bracket, so patern would start 1 after htat
                //patternStart index would've ended up at one index after the last ']', so we need to get to the end of the pattern by going back two indexes.
                
                String pattern = dfs(s, digitStart+1, patternStart - 2);
                
            
                
                for (int j = 0; j < digit; j++) {
                    builder.append(pattern);
                }
                
                i = patternStart;
                
            } else {
                
                // If we don't see a number, then we should build out the pattern.
                builder.append(s.charAt(i));
                i++;
            }
                
            
        }
        
        return builder.toString();
        
    }
    
    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
    
}