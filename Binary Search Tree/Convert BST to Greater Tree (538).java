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
    public TreeNode convertBST(TreeNode root) {
        return convertBST(root, new int[1]);
    }
    
    private TreeNode convertBST(TreeNode root, int[] sum) {
        if (root == null) {
            return null;
        }
        
        convertBST(root.right, sum);
        sum[0] += root.val;
        root.val = sum[0];
        convertBST(root.left, sum);
        
        return root;
    }
}
