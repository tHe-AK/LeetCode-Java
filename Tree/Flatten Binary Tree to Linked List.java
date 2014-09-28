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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        while (root != null) {
            TreeNode cur = root.left;
            
            if (cur != null) {
                while (cur.right != null) {
                    cur = cur.right;
                }
                
                cur.right = root.right;
                root.right = root.left;
                root.left = null;
            }

            root = root.right;
        }
    }
}