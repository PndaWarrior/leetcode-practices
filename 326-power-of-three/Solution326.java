class Solution326 {
    public boolean isPowerOfThree(int n) {
        if(n <= 0 || n == 2) return false;
        if(n == 3 || n == 1) return true;
        
        return (n%3 == 0) && isPowerOfThree(n/3);
        
    }
}