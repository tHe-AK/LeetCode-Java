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
    public TreeNode inorderPresuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        
        if (root.val >= p.val) {
            return inorderPresuccessor(root.left, p);
        } else {
            TreeNode right = inorderPresuccessor(root.left, p);
            return right != null ? right : root;
        }
    }
}
