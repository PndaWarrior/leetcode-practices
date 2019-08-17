class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length() || s2.length() == 0) return false;
        if(s1.length() == 0) return true;
        
        int targetLength = s1.length();
        int[] dictionary = new int[26];
        int[] window = new int[26];
        int lettersMatched = 0;
        
        //add to the dicationary the counts of each letter, and the same as the window map
        for(int i = 0; i < targetLength; i++) {
            dictionary[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }
        
        //Check to see how many letters were matched when we first built the window
        for(int i = 0; i < 26; i++) {
            if(dictionary[i] == window[i]) {
                lettersMatched++;
            }
        }
        
        
        for(int i = 0; i < s2.length() - s1.length(); i++) {
            
            if(lettersMatched == 26) {
                return true;
            } 
            
            int l = s2.charAt(i) - 'a';
            int r = s2.charAt(i + s1.length()) - 'a';
            
            window[r]++;
            
            if (window[r] == dictionary[r]) lettersMatched++;
            else if (window[r] == dictionary[r] + 1) lettersMatched--;
            
            window[l]--;

            if (window[l] == dictionary[l]) lettersMatched++;
            else if (window[l] == dictionary[l] - 1) lettersMatched--;

        }
        
        
        
        return lettersMatched == 26;
        
    }

}