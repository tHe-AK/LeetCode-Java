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
    public int countNodes(TreeNode root) {
        TreeNode left = root;
        TreeNode right = root;
        int height = 0;
        
        while (right != null) {
            left = left.left;
            right = right.right;
            height++;
        }
        
        if (left == null) {
            return (1 << height) - 1;
        }
        
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
