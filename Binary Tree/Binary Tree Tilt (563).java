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
    public int findTilt(TreeNode root) {
        int[] tilt = new int[1];
        postorder(root, tilt);
        return tilt[0];
    }
    
    public int postorder(TreeNode root, int[] tilt) {
        if (root == null) {
            return 0;
        }
        
        int left = postorder(root.left, tilt);
        int right = postorder(root.right, tilt);
        tilt[0] += Math.abs(left - right);
        return left + right + root.val;
    }
}
