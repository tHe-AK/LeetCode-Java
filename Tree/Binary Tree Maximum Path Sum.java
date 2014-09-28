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
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        
        int[] max = new int[1];
        max[0] = root.val;
        
        helper(root, max);
        
        return max[0];
    }
    
    private int helper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        
        int cur = Math.max(Math.max(left, right) + root.val, root.val);
        max[0] = Math.max(max[0], Math.max(cur, left + right + root.val));
        
        return cur;
    }
}