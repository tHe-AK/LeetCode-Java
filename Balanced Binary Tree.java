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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return helper(root, new int[1]);
    }
    
    private boolean helper(TreeNode root, int[] height) {
        if (root == null) {
            height[0] = 0;
            return true;
        }
        
        int[] left = new int[1];
        int[] right = new int[1];
        if (helper(root.left, left) == false) {
            return false;
        }
        if (helper(root.right, right) == false) {
            return false;
        }
        if (Math.abs(left[0] - right[0]) > 1) {
            return false;
        }
        
        height[0] = Math.max(left[0], right[0]) + 1;
        return true;
    }
}
