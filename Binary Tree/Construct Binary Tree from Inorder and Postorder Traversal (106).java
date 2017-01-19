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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        
        int i;
        for (i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[postEnd]) {
                break;
            }
        }
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        root.left = buildTree(inorder, inStart, i - 1, postorder, postStart, postStart + i - 1 - inStart);
        root.right = buildTree(inorder, i + 1, inEnd, postorder, postStart + i - inStart, postEnd - 1);
        
        return root;
    }
}
