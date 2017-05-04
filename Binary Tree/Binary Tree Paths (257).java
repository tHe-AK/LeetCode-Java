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
        List<String> res = new ArrayList<>();
        preorder(root, "", res);
        return res;
    }
    
    private void preorder(TreeNode root, String str, List<String> res) {
        if (root == null) {
            return;
        }
        
        str += (str.isEmpty() ? "" : "->") + root.val;
        
        if (root.left == null && root.right == null) {
            res.add(str);
            return;
        }
        
        preorder(root.left, str, res);
        preorder(root.right, str, res);
    }
}
