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
    public TreeNode bstToGst(TreeNode root) {
        dfs(root, new int[1]);
        return root;
    }
    
    private void dfs(TreeNode root, int[] prev) {
        if (root == null) {
            return;
        }
        
        dfs(root.right, prev);
        root.val += prev[0];
        prev[0] = root.val;
        dfs(root.left, prev);
    }
}
