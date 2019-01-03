class Solution231 {
    public boolean isPowerOfTwo(int n) {
        if(n == 1) return true;
        if(n == 0) return false;
        return (n % 2 == 0 ) && isPowerOfTwo(n/2);
    }
    
    public boolean isPowerOfTwoBinary(int n) {
        if(n<=0) 
            return false;
     
        while(n>2){
            int t = n>>1;
            int c = t<<1;
     
            if(n-c != 0)
                return false;
     
            n = n>>1;
        }
     
        return true;
    }
    
    public boolean isPowerOfTwoConvert(int n) {
    	String convert = Integer.toString(n, 2);
    	
    	return convert.matches("^10*$");
    	
    }
}