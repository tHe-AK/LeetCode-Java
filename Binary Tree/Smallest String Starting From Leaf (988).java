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
    public String smallestFromLeaf(TreeNode root) {
        String[] min = new String[1];
        dfs(root, "", min);
        return min[0];
    }
    
    private void dfs(TreeNode root, String str, String[] min) {
        if (root == null) {
            return;
        }
        
        str = (char) ('a' + root.val) + str;
        
        if (root.left == null && root.right == null) {
            if (min[0] == null || str.compareTo(min[0]) < 0) {
                min[0] = str;
            }
            
            return;
        }
        
        dfs(root.left, str, min);
        dfs(root.right, str, min);
    }
}
