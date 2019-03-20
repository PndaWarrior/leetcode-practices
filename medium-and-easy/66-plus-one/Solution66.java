class Solution66 {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        int result = digits[i] + 1;
        digits[i] = result % 10;
        int carry = result / 10;
        i--;
        while(carry > 0) {
            if(i < 0) {
                int[] temp = digits.clone();
                digits = new int[digits.length + 1];
                for( int j = 1; j < digits.length; j ++ ) {
                    digits[j] = temp[j-1];
                }
                i++;
            }
            
            int current = digits[i] + carry;
            digits[i] = current % 10;
            carry = current / 10;
            i--;
        }
        
        return digits;
    }
}