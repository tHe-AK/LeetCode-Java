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
        if (root == null || k <= 0) {
            throw new IllegalArgumentException();
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                TreeNode peek = stack.pop();
                k--;
                
                if (k == 0) {
                    return peek.val;
                }
                
                root = peek.right;
            }
        }
        
        throw new RuntimeException();
    }
}
