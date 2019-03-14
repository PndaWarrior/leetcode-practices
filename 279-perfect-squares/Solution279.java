import java.util.Arrays;

class Solution279 {
    public int numSquares(int n) {
        int[] calculatedValues = new int[n+1];
        Arrays.fill(calculatedValues, -1);
        calculatedValues[0] = 0;
        calculatedValues[1] = 1;
        
        return findSquares(n, calculatedValues);   
    }
    
    public int findSquares(int n, int[] calculatedValues) {
        if (calculatedValues[n] != -1) return calculatedValues[n];
        if (n == 0) {
            return calculatedValues[0];
        }
        
        calculatedValues[n] = Integer.MAX_VALUE;
        
        int largestSqrt = (int)Math.floor(Math.sqrt(n));

        while (largestSqrt > 0) {
            
            calculatedValues[n] = Math.min(calculatedValues[n], findSquares((n - largestSqrt*largestSqrt), calculatedValues) +1);
            
            largestSqrt--;
        }
        
        
        return calculatedValues[n];
    }
    
    
    
}