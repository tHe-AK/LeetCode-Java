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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root == null) {
            return result;
        }
        
        helper(root, sum, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void helper(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        
        cur.add(root.val);
        
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new ArrayList<Integer>(cur));
        }
        
        helper(root.left, sum - root.val, cur, result);
        helper(root.right, sum - root.val, cur, result);
        
        cur.remove(cur.size() - 1);
    }
}