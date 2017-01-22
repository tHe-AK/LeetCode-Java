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
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    
    private int sumNumbers(TreeNode root, int curr) {
        if (root == null) {
            return 0;
        }
        
        curr = curr * 10 + root.val;
        
        if (root.left == null && root.right == null) {
            return curr;
        } else {
            return sumNumbers(root.left, curr) + sumNumbers(root.right, curr);
        }
    }
}
