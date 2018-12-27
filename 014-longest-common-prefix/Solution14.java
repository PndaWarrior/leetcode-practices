class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String result = strs[0];
        
        for(int i = 1; i < strs.length; i++) {
            String currentResult = longestPrefix(result, strs[i]);
            result = (result.length() > currentResult.length()) ? currentResult : result;
        }
        
        return result;
        
    }
    
    public String longestPrefix(String s1, String s2) {
        int i = 0;
        
        for ( i = 0 ; i < s1.length() && i < s2.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
        }
        return s1.substring(0,i);
    }
}