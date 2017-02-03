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
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        
        if (k == count + 1) {
            return root.val;
        } else if (k <= count) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - 1 - count);
        }
    }
    
    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
