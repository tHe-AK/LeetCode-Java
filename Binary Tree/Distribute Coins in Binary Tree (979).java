/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int distributeCoins(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }
    
    private int dfs(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        res[0] += Math.abs(left) + Math.abs(right);
        
        return left + right + root.val - 1;
    }
}
