class Solution5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int length1 = expandAroundCenter(s, i, i);
            int length2 = expandAroundCenter(s, i, i+1);

            int len = Math.max(length1, length2);
            //the +1 here is not necessary.  we do +1 so we get the exact length, because we need to include character at index 0, a bigger palindrome length will be bigger than end-start as well as end-start + 1, but I like to do end-start + 1 because I know for a fact then it's comparing the lengths
            if(end-start + 1 < len) {
                /*
                The reason why we don't need to have two different case to determine start and end is as follows
                Take the case "aabbaa" and "aabaa"
                Both cases, the center is at index 2
                start of fist case is, 2 - (6-1)/2 = 0
                start of second case is 2 - (5 -1)/2 = 0
                The reason is that 5/2  == 4/2 since decimals gets dropped when dividing an integer
                */
                start = i - (len-1)/2;
                end = i + len/2;
            }

        }

        return s.substring(start, end + 1);
    }
    public int expandAroundCenter(String s, int left, int right) {
        while(left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
            left--;
            right++;
        }
        //Remember we have to do right - left - 1, because while loop does 1 extra step, we need to subtract 1 to get the right length
        return right - left - 1;
    }
}
