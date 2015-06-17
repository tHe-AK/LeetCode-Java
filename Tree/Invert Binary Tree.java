/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        
        return helper(root);
    }
    
    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        root.left = right;
        root.right = left;
        
        return root;
    }
}
