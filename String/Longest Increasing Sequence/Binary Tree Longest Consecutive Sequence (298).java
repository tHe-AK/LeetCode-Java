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
        return longestConsecutive(root, null, 0);
    }

    private int longestConsecutive(TreeNode root, TreeNode parent, int len) {
        if (root == null) {
            return len;
        }
        
        len = (parent != null && root.val == parent.val + 1) ? len + 1 : 1;
        
        return Math.max(len, Math.max(longestConsecutive(root.left, root, len), longestConsecutive(root.right, root, len)));
    }
}
