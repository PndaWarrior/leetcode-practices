import java.util.Arrays;

class Solution91 {
    
    public int numDecodings(String s) {
        int[] memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        return helper(s, 0, memo);
    }
    
    public int helper(String s, int start, int[] memo) {
        
        if(memo[start] != -1) return memo[start];
        
        if(s.length() - start == 0) return 1;
        if(s.charAt(start) == '0') return 0;
        if(s.length() - start == 1) return 1;
        
        int firstCase = helper(s, start + 1, memo);
        
        int secondCase = 0;
        
        if(Integer.parseInt(s.substring(start, start+2)) <= 26) {
            secondCase = helper(s, start + 2, memo);
        }
        
        memo[start] = firstCase + secondCase;
        
        return memo[start];
        
        
    }
    
    
    
    
    
}