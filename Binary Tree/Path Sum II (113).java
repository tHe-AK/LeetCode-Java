/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        
        dfs(root, sum, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void dfs(TreeNode root, int sum, List<Integer> curr, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        
        curr.add(root.val);
        
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new ArrayList<Integer>(curr));
        } else {
            dfs(root.left, sum - root.val, curr, result);
            dfs(root.right, sum - root.val, curr, result);
        }
        
        curr.remove(curr.size() - 1);
    }
}
