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
            return 0;
        }
        
        int[] maxPath = new int[1];
        maxPath[0] = root.val;
        helper(root, maxPath);
        
        return maxPath[0];
    }
    
    private int helper(TreeNode root, int[] maxPath) {
        if (root == null) {
            return 0;
        }
        
        int left = helper(root.left, maxPath);
        int right = helper(root.right, maxPath);
        
        int singlePath = Math.max(Math.max(left, right) + root.val, root.val);
        maxPath[0] = Math.max(maxPath[0], Math.max(singlePath, left + root.val + right));
        
        return singlePath;
    }
}
