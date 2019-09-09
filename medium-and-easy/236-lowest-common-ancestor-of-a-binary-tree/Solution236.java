/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution236 {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    
    TreeNode answer;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        lcaExists(root, p, q);
        return answer;
    }
    
    public boolean lcaExists(TreeNode root, TreeNode p, TreeNode q) {
        //The idea is basically the same as if we're checking LCA or P or Q exists
        //if we get to a leaf node root, then return false
        if( root == null ) return false;
        
        //This checks the left side, does it have either p or q or the LCA
        boolean left = lcaExists(root.left, p, q);
        
        //This checks the right side, does it have either p or q or the LCA
        boolean right = lcaExists(root.right, p, q);
        
        //This checks if I myself am either p or q.
        boolean self = (root == q || root == p);
        
        
        //Here are the three conditions
        //if left == true and right == true, this must means we found something on both side of the tree, this could only mean that the current root is the LCA
        //if self == true meaning current root is either p or q, and we found something either on the left side or the right side, then it can only mean that the current is also the LCA, because if p is parent of q, then p must be LCA
        if ( (left && right) || (self && left) || (self && right) ) {
            answer = root;
        }
        
        //It's possible that left is true, because both P and Q resides on the left, so right would be null
        //Vice versa for right
        //Last case is it's possible that I found myself, which is p or q and there's nothing to the left or right of me
        return self || left || right;
        
    }
    

}