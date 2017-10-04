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
    public int longestUnivaluePath(TreeNode root) {
        int[] res = new int[1];
        traverse(root, res);
        return res[0];
    }
    
    private int traverse(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        
        boolean sameLeft = root.left != null && root.left.val == root.val;
        boolean sameRight = root.right != null && root.right.val == root.val;
        int left = traverse(root.left, res);
        int right = traverse(root.right, res);
        
        if (sameLeft) {
            left++;
        } else {
            left = 0;
        }
        
        if (sameRight) {
            right++;
        } else {
            right = 0;
        }
        
        res[0] = Math.max(res[0], left + right);
        
        return Math.max(left, right);
    }
}
