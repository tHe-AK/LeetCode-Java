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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        
        if (root.val <= min || root.val >= max) {
            return false;
        }
        
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}

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
    public boolean isValidBST(TreeNode root) {
        return inorder(root, new TreeNode[1]);
    }
    
    private boolean inorder(TreeNode root, TreeNode[] pre) {
        if (root == null) {
            return true;
        }
        
        if (!inorder(root.left, pre) || (pre[0] != null && pre[0].val >= root.val)) {
            return false;
        }
        
        pre[0] = root;
        
        return inorder(root.right, pre);
    }
}
