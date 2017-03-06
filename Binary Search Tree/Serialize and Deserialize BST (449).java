/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        
        return sb.length() == 0 ? " " : sb.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        
        sb.append(root.val + " ");
        
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialize(Arrays.asList(data.split(" ")).listIterator(), Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private TreeNode deserialize(ListIterator<String> it, long min, long max) {
        if (!it.hasNext()) {
            return null;
        }
        
        int val = Integer.parseInt(it.next());
        
        if (val <= min || val >= max) {
            it.previous();
            return null;
        }
        
        TreeNode root = new TreeNode(val);
        root.left = deserialize(it, min, val);
        root.right = deserialize(it, val, max);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
