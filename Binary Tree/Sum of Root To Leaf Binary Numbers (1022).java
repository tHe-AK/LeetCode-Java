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
    public int sumRootToLeaf(TreeNode root) {
        int[] sum = new int[1];
        dfs(root, 0, sum);
        return sum[0];
    }
    
    private void dfs(TreeNode root, int val, int[] sum) {
        if (root == null) {
            return;
        }
        
        val = (val << 1) + root.val;
        
        if (root.left == root.right) {
            sum[0] += val;
        } else {
            dfs(root.left, val, sum);
            dfs(root.right, val, sum);
        }
    }
}

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
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        
        val = (val << 1) + root.val;
        
        if (root.left == root.right) {
            return val;
        } else {
            return dfs(root.left, val) + dfs(root.right, val);
        }
    }
}
