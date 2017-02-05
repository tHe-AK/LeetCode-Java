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
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        
        traverse(root, count);
        
        return count[0];
    }
    
    private boolean traverse(TreeNode root, int[] count) {
        if (root == null) {
            return true;
        }
        
        boolean left = traverse(root.left, count);
        boolean right = traverse(root.right, count);
        
        if (left && right) {
            if (root.left != null && root.val != root.left.val) {
                return false;
            } else if (root.right != null && root.val != root.right.val) {
                return false;
            } else {
                count[0]++;
                return true;
            }
        }
        
        return false;
    }
}
