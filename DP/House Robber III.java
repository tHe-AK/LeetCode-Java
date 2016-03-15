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
    public int rob(TreeNode root) {
        int[] result = helper(root);
        
        return Math.max(result[0], result[1]);
    }
    
    private int[] helper(TreeNode root) {
        int[] cur = new int[2];
        
        if (root == null) {
            return cur;
        }
        
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        cur[0] = left[1] + right[1] + root.val;
        cur[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return cur;
    }
}
