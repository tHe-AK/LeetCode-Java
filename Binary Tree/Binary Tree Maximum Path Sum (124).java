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
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        
        postorder(root, max);
        
        return max[0];
    }
    
    private int postorder(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        
        int left = postorder(root.left, max);
        int right = postorder(root.right, max);
        
        int curr = Math.max(Math.max(left, right) + root.val, root.val);
        max[0] = Math.max(max[0], Math.max(curr, left + right + root.val));
        
        return curr;
    }
}
