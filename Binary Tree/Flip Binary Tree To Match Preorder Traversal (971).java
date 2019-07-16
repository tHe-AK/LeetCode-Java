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
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        int[] idx = new int[1];
        List<Integer> res = new ArrayList<>();
        return dfs(root, voyage, idx, res) ? res : Arrays.asList(-1);
    }
    
    private boolean dfs(TreeNode root, int[] voyage, int[] idx, List<Integer> res) {
        if (root == null) {
            return true;
        }
        
        if (root.val != voyage[idx[0]++]) {
            return false;
        }
        
        if (root.left != null && root.left.val != voyage[idx[0]]) {
            res.add(root.val);
            return dfs(root.right, voyage, idx, res) && dfs(root.left, voyage, idx, res);
        }
        
        return dfs(root.left, voyage, idx, res) && dfs(root.right, voyage, idx, res);
    }
}
