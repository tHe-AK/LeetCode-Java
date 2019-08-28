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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        
        for (int i : to_delete) {
            set.add(i);
        }
        
        List<TreeNode> res = new ArrayList<>();
        dfs(root, true, set, res);
        return res;
    }
    
    private TreeNode dfs(TreeNode root, boolean isRoot, Set<Integer> set, List<TreeNode> res) {
        if (root == null) {
            return null;
        }
        
        boolean toDelete = set.contains(root.val);
        
        if (!toDelete && isRoot) {
            res.add(root);
        }
        
        root.left = dfs(root.left, toDelete, set, res);
        root.right = dfs(root.right, toDelete, set, res);
        return toDelete ? null : root;
    }
}
