import java.util.Stack;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */



class BSTIterator173 {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	Stack<TreeNode> stack;

	public BSTIterator173(TreeNode root) {
        if (root == null) { return; }
        stack = new Stack<TreeNode>();
        stack.push(root);
    }

	/** @return the next smallest number */
	public int next() {
		TreeNode current = stack.peek();

		while (current.left != null) {
			current = current.left;
			stack.push(current);
		}

		TreeNode min = stack.pop();
		int minVal = min.val;

		if (!stack.isEmpty()) {
			stack.peek().left = null;
		}

		if (min.right != null)
			stack.push(min.right);
		return minVal;

	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return stack != null && !stack.isEmpty();

	}
}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator
 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */