/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


class Solution222 {
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	
    public int countNodes(TreeNode root) {
        
        return numNodes(root);
        
    }
    
    public int numNodes(TreeNode current) {
        if(current == null) {
            return 0;
        }
        
        return numNodes(current.left) + numNodes(current.right) + 1;
    }
}