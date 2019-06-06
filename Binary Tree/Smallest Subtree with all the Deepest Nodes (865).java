/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return postorder(root)[0];
    }
    
    private TreeNode[] postorder(TreeNode root) {
        if (root == null) {
            return new TreeNode[] { null, new TreeNode(0) };
        }
        
        TreeNode[] left = postorder(root.left);
        TreeNode[] right = postorder(root.right);
        int depth1 = left[1].val;
        int depth2 = right[1].val;
        int depth = Math.max(depth1, depth2) + 1;
        TreeNode node = null;
        
        if (depth1 > depth2) {
            node = left[0];
        } else if (depth1 < depth2) {
            node = right[0];
        } else {
            node = root;
        }
        
        return new TreeNode[] { node, new TreeNode(depth) };
    }
}
