import java.util.Arrays;

class Solution87 {
    public boolean isScramble(String s1, String s2) {
        int[][][] dp = new int[s1.length()][s2.length()][s1.length()+1];
        
        return checkScramble(dp, s1, s2, 0, 0, s1.length()) == 1;
    }
    
    public int checkScramble(int[][][] dp, String s1, String s2, int s1_i, int s2_i, int length) {
    	
        if(dp[s1_i][s2_i][length] != 0) {
            return dp[s1_i][s2_i][length] ;
            
        } else if (length == 0 || s1.equals(s2)) {
            dp[s1_i][s2_i][length] = 1;
            
        } else if (!isValid(s1, s2)) {
            dp[s1_i][s2_i][length] = -1;
            
        } else {

            for(int i = 1; i < s1.length(); i++) {
                
                String s11 = s1.substring(0, i);
                String s12 = s1.substring(i, s1.length());
                
                String s21 = s2.substring(0, i);
                String s22 = s2.substring(i, s2.length());
                String s23 = s2.substring(s2.length() - i, s2.length());
                String s24 = s2.substring(0, s2.length() - i);
                
                dp[s1_i][s2_i][length] = -1;
                
                if(checkScramble(dp, s11, s21, s1_i, s2_i, i) == 1 && checkScramble(dp, s12, s22, s1_i + i, s2_i + i, length - i) == 1) {
                    dp[s1_i][s2_i][length] = 1;
                    break;
                }
                
                if(checkScramble(dp, s11, s23, s1_i, s2_i + length - i, i) == 1 && checkScramble(dp, s12, s24, s1_i + i, s2_i , length - i) == 1) {
                    dp[s1_i][s2_i][length] = 1;
                    break;
                }
            }
        }
        return dp[s1_i][s2_i][length];
        
    }
    
    public boolean isValid(String s1, String s2) {
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        if(new String(array1).equals(new String(array2))) {
            return true;
        }
        return false;
    }
    
}