class Solution29Slow {
    public int divide(int dividend, int divisor) {
        
        //If dividend is -2^32, and divisor = -1, this will result in 2^32, which overflowed
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        //if divisor is -2^32, unless dividend is also -2^32, or else since when we do division we will calculate by using abolute number, so divisor is considered as 2^32 which is the largest number there is in the range
        if (divisor == Integer.MIN_VALUE) return (dividend == Integer.MIN_VALUE) ? 1 : 0;
        
        //Edge Cases
        if (divisor == 1) return dividend;
        if (divisor == -1) return -dividend;
        if (divisor == 2) return dividend >> 1;
        if (divisor == -2) return -dividend >> 1;
        
        
        boolean isNegative = false;
        if (dividend < 0 ^ divisor < 0) {
            isNegative = true;
        }
        
        int answer = 0;
        
        if (dividend == Integer.MIN_VALUE) {
            dividend += Math.abs(divisor);
            answer = 1;
        }
        
        int positiveDividend = Math.abs(dividend);
        int positiveDivisor = Math.abs(divisor);
        
        while( positiveDividend >= positiveDivisor) {
            positiveDividend -= positiveDivisor;
            answer++;
        }
        
        
        return (isNegative) ? -1 * answer : answer;
    }
    
}