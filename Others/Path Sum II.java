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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<ArrayList<Integer>>();
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        helper(root, sum, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void helper(TreeNode root, int sum, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> result) {
        if (root == null) {
            return;
        }
        
        cur.add(root.val);
        sum -= root.val;
        
        if (sum == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<Integer>(cur));
            cur.remove(cur.size() - 1);
            return;
        }
        
        helper(root.left, sum, cur, result);
        helper(root.right, sum, cur, result);
        
        cur.remove(cur.size() - 1);
    }
}
