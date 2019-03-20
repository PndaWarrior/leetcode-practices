class Solution832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int length = A[0].length;
        
        for(int[] row : A) {
            for (int i = 0; i < (length + 1) / 2; i++) {
                int temp = row[i]^1;
                row[i] = row[length - i - 1] ^ 1;
                row[length - i - 1] = temp;
            }
            
        }
        
        return A;
        
    }
}