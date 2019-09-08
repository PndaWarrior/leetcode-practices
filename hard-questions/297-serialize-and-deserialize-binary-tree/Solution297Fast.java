public class Solution297Fast {
    public static final String NN = "N";
    public static final String DELIMITER = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return NN;
        return root.val + DELIMITER + serialize(root.left) + DELIMITER + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] t = new int[1];
        return deserialize(data, t);
    }

    private TreeNode deserialize(String data, int[] t) {
        if(String.valueOf(data.charAt(t[0])).equals(NN)) {
            t[0] += 2;
            return null;
        }
        int idx = data.indexOf(DELIMITER, t[0]);
        int val = Integer.valueOf(data.substring(t[0], idx));
        TreeNode node = new TreeNode(val);
        t[0] = idx + 1;

        node.left = deserialize(data, t);
        node.right = deserialize(data, t);

        return node;
    }
}
