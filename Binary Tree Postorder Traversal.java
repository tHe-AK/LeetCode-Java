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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        
        ArrayList<Integer> rec = new ArrayList<Integer>();
        helper(root, rec);
        
        return rec;
    }
    
    private void helper(TreeNode root, ArrayList<Integer> rec) {
        if (root == null) {
            return;
        }
        
        helper(root.left, rec);
        helper(root.right, rec);
        
        rec.add(root.val);
    }
}
