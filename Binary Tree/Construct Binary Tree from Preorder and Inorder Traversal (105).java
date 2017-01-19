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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        
        int i;
        for (i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                break;
            }
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = buildTree(preorder, preStart + 1, preStart + i - inStart, inorder, inStart, i - 1);
        root.right = buildTree(preorder, preStart + i - inStart + 1, preEnd, inorder, i + 1, inEnd);
        
        return root;
    }
}
