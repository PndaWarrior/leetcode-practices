
public class Solution29Fast {
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
        
        answer += dividePositive(Math.abs(dividend), Math.abs(divisor));
        
        return (isNegative) ? -answer : answer;
    }
    
    private int dividePositive(int dividend, int divisor) {
	    int result = 0;
	    while (dividend >= divisor) {
	        int tmp = divisor;
	        int count = 1;
	        // The trick here is that, instead of subtracting one by one, for large numbers, we can attempt to double the amount we're dividing each time
	        // If tmp = 3, and dividend = 1000, we will first get tmp = 3 and count = 1
	        // then tmp = 6, count = 2
	        // then tmp = 12, count = 4
	        // then tmp = 24, count = 8 and so on
	        // So the amount of operation we would need to do is basically Log dividend
	        while (tmp + tmp < dividend && tmp + tmp > 0) {
	            tmp += tmp;
	            count += count;
	        }
	        dividend -= tmp;
	        result += count;
	    }
	    return result;
	}

}
