class Solution844 {
    public boolean backspaceCompare(String S, String T) {
        
        int i = S.length() - 1;
        int j = T.length() - 1;
        int backspaceI = 0;
        int backspaceJ = 0;
        
        while (i >= 0 || j >= 0) {
            
            //Move the first pointer until I get a charcter
            while (i >= 0) {
                if(S.charAt(i) == '#') {
                    backspaceI++;
                    i--;
                } else if (backspaceI > 0) {
                    backspaceI--;
                    i--;
                } else {
                    break;
                }
            }
            
            //move the second pointer until I get a character
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    backspaceJ++;
                    j--;
                } else if (backspaceJ > 0) {
                    backspaceJ--;
                    j--;
                } else {
                    break;
                }
            }
            
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j) ) {
                return false;
            } 
            if ((i >= 0) != (j >= 0)) {
                return false;
            } 
            
            i--;
            j--;
            
        }
        
        return true;
        
    }
}