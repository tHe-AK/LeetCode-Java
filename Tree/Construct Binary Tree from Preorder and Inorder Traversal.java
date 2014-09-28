/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null || preorder == null) {
            throw new IllegalArgumentException();
        }
        
        return helper(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }
    
    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd) {
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }
        
        int i;
        for (i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                break;
            }
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = helper(inorder, inStart, i - 1, preorder, preStart + 1, preStart + i - inStart);
        root.right = helper(inorder, i + 1, inEnd, preorder, preStart + i - inStart + 1, preEnd);
        
        return root;
    }
}