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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        
        insert(root, v, d - 1);
        return root;
    }

    public void insert(TreeNode root, int v, int d) {
        if (root == null) {
            return;
        }
        
        if (d == 1) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = new TreeNode(v);
            root.right = new TreeNode(v);
            root.left.left = left;
            root.right.right = right;
        } else {
            insert(root.left, v, d - 1);
            insert(root.right, v, d - 1);
        }
    }
}
