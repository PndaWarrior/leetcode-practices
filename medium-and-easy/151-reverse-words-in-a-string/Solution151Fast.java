class Solution151Fast {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        int n = s.length();
        int start = n-1;
        int end = n-1;
        
        while(end >= 0) {
            
            while(end >= 0 && arr[end] == ' ') {
                end-- ;
            }
            start = end;
            
            while(start > 0 && arr[start-1] != ' ') {
                start--;
            }
            
            if(start >= 0 && end >= 0) {

                sb.append( " " + s.substring(start, end+1));
            }
            end = start - 1;
        }
        
        String result = sb.toString();
        
        if(result.length() > 0 && result.charAt(0) == ' ') return result.trim();
        
        return result;
    }
}