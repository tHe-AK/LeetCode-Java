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
    public int longestConsecutive(TreeNode root) {
        return helper(root, null, 0);
    }

    private int helper(TreeNode root, TreeNode parent, int len) {
        if (root == null) {
            return len;
        }
        
        len = (parent != null && root.val == parent.val + 1) ? len + 1 : 1;
        
        return Math.max(len, Math.max(helper(root.left, root, len), helper(root.right, root, len)));
    }
}
