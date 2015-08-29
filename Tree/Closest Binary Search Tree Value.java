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
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        
        int rootVal = root.val;
        TreeNode child = target < rootVal ? root.left : root.right;
        
        if (child == null) {
            return rootVal;
        }
        
        int childVal = closestValue(child, target);
        
        return Math.abs(rootVal - target) < Math.abs(childVal - target) ? rootVal : childVal;
    }
}
