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
        if (root == null) {
            return 0;
        }
        
        int left = leftHeight(root.left);
        int right = rightHeight(root.right);
        
        if (left == right) {
            return (1 << (left + 1)) - 1;
        }
        else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
    
    private int leftHeight(TreeNode root) {
        int height = 0;
        
        if (root == null) {
            return height;
        }
        
        while (root != null) {
            height++;
            root = root.left;
        }
        
        return height;
    }
    
    private int rightHeight(TreeNode root) {
        int height = 0;
        
        if (root == null) {
            return height;
        }
        
        while (root != null) {
            height++;
            root = root.right;
        }
        
        return height;
    }
}
