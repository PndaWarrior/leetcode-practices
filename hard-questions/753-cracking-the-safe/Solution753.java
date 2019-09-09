import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution753 {
    public String crackSafe(int n, int k) {
        /* backtracking: each node is a password
        https://www.youtube.com/watch?v=kRdlLahVZDc */
        
        //The idea is that, in order to parse through all possible passwords, we need to visit k^n possible combinations
        //For each possible password combinations, we can transition to another password combination, by reusing the last n-1 characters and append one of the password combination
        
        //Example, int n = 3, int k = 2, the optimal solution is "0001011100"
        // To start off, 000 is a possible combination, we add 000 int a visited possible combination
        // To get from 000 to the next state, since the next character could be either a 0 or 1, consider if we use the last n-1 characters, which is 00, and if we append 0 to it, we see that 000 is already in the visited state, but we can append a 1 to it to get 001.  This is a new password so we add this to the visited set, and we need to add 1 to our result string, so now we have 0001, where both the case of possible password combination has been considered.
        // Next from 0001, the last n-1 characters are 01, and there are two ways we can add the next character, forming either 010 or 011, both are possible password.  HOWEVER, we don't know whether if we form using a 0 first here would yield the optimal answer, or using a 1 here would yield the best result, so we need to use backtracking.  First we check the dfs of using a 0, and if it does yield a possible optial answer, then we return, but if it doesn't we have to back track by removing the character we appended from previous prefix, as well as removing the password from the visited set.
        
        int size = (int) Math.pow(k, n);  /* total num nodes inside graph */
        
        /* initialize password to be n digits of '0's */
        char[] password = new char[n];
        Arrays.fill(password, '0');
        StringBuilder res = new StringBuilder(String.valueOf(password));
        
        Set<String> visited = new HashSet<>(); 
        visited.add(res.toString()); 
        
        /* traverse each node exactly once to minimize the result  */
        if (dfs(res, visited, n, k, size)) return res.toString(); 
        return ""; 
    }
    
    /*  A node in the graph is one possible combination of n digits 
        where each digit is chosen from [0,k)
        e.g.    n = 2, k = 2, 
                total combination = 4 (00, 01, 10, 11)
                n = 3, k = 6
                total combination = 6^3
                (each of the 3 digits has 6 possibilities, [0-5])
    */
    public boolean dfs(StringBuilder res, Set<String> visited, int n, int k, int size) {
        /* base case: all nodes are visited  */
        if (visited.size() == size) return true;
        
        /* reuse (n-1) digits from last node to form new node */
        String prefix = res.substring(res.length()-n+1, res.length());
       
	   /* append one digit to prefix */
        for (char i = '0'; i<'0'+ k; i++) {
            String password = prefix+i;
            if (!visited.contains(password)) {
                res.append(i);
                visited.add(password); 
                if (dfs(res, visited, n, k, size)) return true; 
                visited.remove(password);  /* backtracking */
                res.deleteCharAt(res.length()-1); 
            }
        }
        return false; 
    }
}