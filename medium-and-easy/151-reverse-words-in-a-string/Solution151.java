import java.util.Arrays;

class Solution151 {
    public String reverseWords(String s) {

        String[] resultArray = Arrays.stream(s.trim().split(" ")).filter( str -> !str.equals("")).toArray(String[]::new);
        
        int n = resultArray.length;
        
        if (n > 1) {
            for (int i = 0; i < n/2; i++) {
                String temp = resultArray[i];
                resultArray[i] = resultArray[n-i-1];
                resultArray[n-1-i] = temp;
            }
        }
        
        return String.join(" ", resultArray);
        
    }
}