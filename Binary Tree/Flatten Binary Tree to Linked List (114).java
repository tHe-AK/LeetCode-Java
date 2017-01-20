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
    public void flatten(TreeNode root) {
        flatten(root, new TreeNode[1]);
    }
    
    private void flatten(TreeNode root, TreeNode[] pre) {
        if (root == null) {
            return;
        }
        
        flatten(root.right, pre);
        flatten(root.left, pre);
        
        root.right = pre[0];
        root.left = null;
        pre[0] = root;
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
    public void flatten(TreeNode root) {
        while (root != null) {
            TreeNode curr = root.left;
            
            if (curr != null) {
                while (curr.right != null) {
                    curr = curr.right;
                }
                
                curr.right = root.right;
                root.right = root.left;
                root.left = null;
            }

            root = root.right;
        }
    }
}
