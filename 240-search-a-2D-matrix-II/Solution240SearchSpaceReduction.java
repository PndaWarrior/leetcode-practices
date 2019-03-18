public class Solution240SearchSpaceReduction {  
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null) return false;
        
        int row = matrix.length - 1;
        int col = 0;
        
        while(row >= 0 && col < matrix[0].length) {
            if(matrix[row][col] > target) {
                row--;
            } else if(matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }
        
        return false;
        
    }
}