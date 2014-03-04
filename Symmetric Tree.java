/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        else if (left != null && right != null && left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left)) {
            return true;
        }
        else {
            return false;
        }
    }
}
