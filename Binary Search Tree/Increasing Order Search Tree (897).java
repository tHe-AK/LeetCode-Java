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
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        TreeNode[] prev = new TreeNode[1];
        prev[0] = dummy;
        
        inorder(root, prev);
        
        return dummy.right;
    }
    
    private void inorder(TreeNode root, TreeNode[] prev) {
        if (root == null) {
            return;
        }
        
        inorder(root.left, prev);
        root.left = null;
        prev[0].right = root;
        prev[0] = root;
        inorder(root.right, prev);
    }
}
