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
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        TreeNode predecessor = null;
        
        while (root != null) {
            if (root.val >= p.val) {
                root = root.left;
            } else {
                predecessor = root;
                root = root.right;
            }
        }
        
        return predecessor;
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
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        
        if (root.val >= p.val) {
            return inorderSuccessor(root.left, p);
        } else {
            TreeNode right = inorderPredecessor(root.right, p);
            return right != null ? right : root;
        }
    }
}
