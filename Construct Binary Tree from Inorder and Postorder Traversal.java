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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        
        int len = inorder.length;
        TreeNode root = helper(inorder, 0, len - 1, postorder, 0, len - 1);
        
        return root;
    }
    
    private TreeNode helper(int[] inorder, int in_s, int in_e, int[] postorder, int post_s, int post_e) {
        if (in_s > in_e || post_s > post_e) {
            return null;
        }
        
        int cur = postorder[post_e];
        int pos = -1;
        for (int i = in_s; i <= in_e; i++) {
            if (inorder[i] == cur) {
                pos = i;
                break;
            }
        }
        
        TreeNode root = new TreeNode(cur);
        root.left = helper(inorder, in_s, pos - 1, postorder, post_s, post_s + pos - 1 - in_s);
        root.right = helper(inorder, pos + 1, in_e, postorder, post_s + pos - in_s, post_e - 1);
        
        return root;
    }
}
