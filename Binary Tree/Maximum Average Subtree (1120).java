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
    public double maximumAverageSubtree(TreeNode root) {
        double[] res = new double[1];
        dfs(root, res);
        return res[0];
    }
    
    private int[] dfs(TreeNode root, double[] res) {
        if (root == null) {
            return new int[] { 0, 0 };
        }
        
        int[] left = dfs(root.left, res);
        int[] right = dfs(root.right, res);
        int sum = left[0] + right[0] + root.val;
        int count = left[1] + right[1] + 1;
        res[0] = Math.max(res[0], 1.0 * sum / count);
        return new int[] { sum, count };
    }
}
