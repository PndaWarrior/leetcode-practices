class Solution9 {
    public boolean isPalindrome(int x) {
        int temp = x;
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversed = 0;
        while(temp != 0) {
            reversed = reversed * 10 + temp % 10;
            temp /= 10;
        }
        return reversed == x;
    }
}
