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
        
        int[] result = new int[1];
        result[0] = root.val;
        helper(root, result);
        
        return result[0];
    }
    
    private int helper(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }
        
        int left = helper(root.left, result);
        int right = helper(root.right, result);
        int cur = Math.max(root.val, Math.max(left, right) + root.val);
        result[0] = Math.max(result[0], Math.max(cur, root.val + left + right));
        
        return cur;
    }
}
