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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        
        if (root == null) {
            return result;
        }
        
        helper(root, result, "");
        
        return result;
    }
    
    private void helper(TreeNode root, List<String> result, String path) {
        if (root.left == null && root.right == null) {
            result.add(path + root.val);
        }
        
        if (root.left != null) {
            helper(root.left, result, path + root.val + "->");
        }
        
        if (root.right != null) {
            helper(root.right, result, path + root.val + "->");
        }
    }
}
