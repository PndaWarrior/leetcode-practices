class Solution227 {
    public int calculate(String s) {
        
        //The straight forward approach to this problme is to simply perform two pass throughs, first pass through to take care of all the multiplications and divisions, where the second pass through takes care of all additions and subtracitions.
        
        //However, we can turn the problem around a bit, understand that we don't need to pass through twice, that is because if let's say for 6 + 5 * 2, I know that I need to evaluate 5 * 2 first, but the number 6, I can simply add it to the final answer first.  This works becuase there's only two level of calculation, one at the front, one at the back.  The one at the back (which is for addition and subtraction) I can simply add to the final answer straight up, and the calculation at the front (multiplication and division) I can keep a temporary value to store the current result.  This way we only need to pass through once.
        
        //For simplicity sake, let's just remove all spaces at the beginning,  if I don't, then when I'm calculating the divison and multiplication, I would also need to check for cases when it's a space
        
        s = s.replaceAll(" ", "");
        
        //I use a sign to indicate whether the previous value that I'm calculating out should be a addition or subtraction
        int sign = 1, 
        answer = 0,
        previous = 0;
        
        int i = 0;
        while (i < s.length() ) {
            
            char currentChar = s.charAt(i);
            if( isDigit(currentChar) ) {
                previous = previous * 10 + currentChar - '0';
                i++;
            } else {
                
                if (currentChar == '+' || currentChar == '-') {
                    
                    answer += previous * sign;
                    sign = (currentChar == '+') ? 1 : -1;
                    previous = 0;
                    i++;
                } else {
                    
                    // If it's a divison or multiplication operator, then we need evaluate the current operation, which requires the next number
                    i++;
                    int next = 0;
                    while( i < s.length() && isDigit(s.charAt(i))) {
                        next = next * 10 + s.charAt(i) - '0';
                        i++;
                    }
                    
                    previous = (currentChar == '/') ? previous / next : previous * next;
                    
                    
                }
                
                
            }
            
        }
        
        
        return answer += previous * sign;
        
        
    }
    
    public boolean isDigit(char c) {
        return c <= '9' && c >= '0';
    }
}