import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */



public class Solution297 {
	public class TreeNode {
	     int val;
	     TreeNode left;     
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        return recursiveSerialize(root, "");
    }
    
    public String recursiveSerialize(TreeNode node, String answer) {
        
        if(node == null) {
            answer += "null,";
        } else {
            answer += String.valueOf(node.val) + ",";
            answer = recursiveSerialize(node.left, answer);
            answer = recursiveSerialize(node.right, answer);
        }
        
        return answer;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        
        return recursiveDeserialize(data_list);
    }
    
    public TreeNode recursiveDeserialize(List<String> list) {
        
        if(list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        
        
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = recursiveDeserialize(list);
        root.right = recursiveDeserialize(list);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));