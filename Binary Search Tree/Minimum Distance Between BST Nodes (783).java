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
    public int minDiffInBST(TreeNode root) {
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        inorder(root, new Integer[1], min);
        return min[0];
    }
    
    private void inorder(TreeNode root, Integer[] prev, int[] min) {
        if (root == null) {
            return;
        }
        
        inorder(root.left, prev, min);
        if (prev[0] != null) {
            min[0] = Math.min(min[0], root.val - prev[0]);
        }
        prev[0] = root.val;
        inorder(root.right, prev, min);
    }
}
