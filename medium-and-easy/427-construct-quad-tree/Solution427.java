/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution427 {
	class Node {
	    public boolean val;
	    public boolean isLeaf;
	    public Node topLeft;
	    public Node topRight;
	    public Node bottomLeft;
	    public Node bottomRight;

	    public Node() {}

	    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
	        val = _val;
	        isLeaf = _isLeaf;
	        topLeft = _topLeft;
	        topRight = _topRight;
	        bottomLeft = _bottomLeft;
	        bottomRight = _bottomRight;
	    }
	};
	
    public Node construct(int[][] grid) {
        
        if(grid.length == 0) return null;
        
        return createNode(grid, 0, 0, grid.length);
        
        
    }
    
    public Node createNode(int[][] grid, int row, int col, int length) {
        
        if(length == 1) {
            return new Node(grid[row][col] == 1, true, null, null, null, null);
        } else {
            Node topLeft = createNode(grid, row, col, length/2);
            Node topRight = createNode(grid, row , col + length/2, length/2);
            Node bottomLeft = createNode(grid, row+length/2, col, length/2);
            Node bottomRight = createNode(grid, row + length/2, col + length/2, length/2);
            
            if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
                return new Node(grid[row][col] == 1, true, null, null, null, null);
            } else {
                return new Node(grid[row][col] == 1, false, topLeft, topRight, bottomLeft, bottomRight);
            }
            
            
        }

    }
    
    
    
}