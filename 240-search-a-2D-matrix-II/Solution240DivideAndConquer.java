
public class Solution240DivideAndConquer {
	    
	    private int[][] matrix;
	    private int target;
	    
	    public boolean divideAndConquer(int left, int right, int up, int down) {
	        
	        System.out.println("left: " + left + " | right: " + right + " | up: " + up + " | down: " + down);
	        if(left > right || up > down || right >= matrix[up].length || down >= matrix.length) {
	            return false;
	        } else if (target < matrix[up][left] || target > matrix[down][right]) {
	            return false;    
	        } 
	         else if (matrix[up][left] == target) {
	           return true;  
	         } 
	        
	        int midRow = left + (right-left)/2;
	        int midColumn = up + (down-up)/2;
	        
	        return divideAndConquer(left, midRow, up, midColumn) 
	            || divideAndConquer(midRow+1, right, up, midColumn) 
	            || divideAndConquer(left, midRow, midColumn+1, down) 
	            || divideAndConquer(midRow+1, right, midColumn+1, down);
	        
	        
	        
	    }
	    
	    public boolean searchMatrix(int[][] matrix, int target) {
	        if(matrix.length == 0 || matrix == null) return false;
	        
	        this.matrix = matrix;
	        this.target = target;
	        
	        return divideAndConquer(0, matrix[0].length-1, 0, matrix.length - 1);
	        
	    }
}
