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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int[] sum = new int[1];
        
        helper(root, 0, sum);
        
        return sum[0];
    }
    
    private void helper(TreeNode root, int cur, int[] sum) {
        if (root == null) {
            return;
        }
        
        cur = cur * 10 + root.val;
        
        if (root.left == null && root.right == null) {
            sum[0] += cur;
            return;
        }
        
        helper(root.left, cur, sum);
        helper(root.right, cur, sum);
    }
}