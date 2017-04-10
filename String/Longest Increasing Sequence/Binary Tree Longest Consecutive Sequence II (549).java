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
    public int longestConsecutive(TreeNode root) {
        int[] max = new int[1];
        postorder(root, max);
        
        return max[0];
    }
    
    private int[] postorder(TreeNode root, int[] max) {
        if (root == null) {
            return new int[2];
        }
        
        int inr = 1;
        int dcr = 1;
        
        if (root.left != null) {
            int[] left = postorder(root.left, max);

            if (root.val == root.left.val + 1) {
                dcr = left[1] + 1;
            } else if (root.val == root.left.val - 1) {
                inr = left[0] + 1;
            }
        }
        
        if (root.right != null) {
            int[] right = postorder(root.right, max);
        
            if (root.val == root.right.val + 1) {
                dcr = Math.max(dcr, right[1] + 1);
            } else if (root.val == root.right.val - 1) {
                inr = Math.max(inr, right[0] + 1);
            }
        }
        
        max[0] = Math.max(max[0], inr + dcr - 1);
        return new int[] { inr, dcr };
    }
}
