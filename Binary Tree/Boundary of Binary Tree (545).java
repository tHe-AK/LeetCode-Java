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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        if (!isLeaf(root)) {
            res.add(root.val);
        }
        
        TreeNode t = root.left;
        
        while (t != null) {
            if (!isLeaf(t)) {
                res.add(t.val);
            }
            if (t.left != null) {
                t = t.left;
            } else {
                t = t.right;
            }
        }
        
        addLeaves(root, res);
        Stack<Integer> s = new Stack<>();
        t = root.right;
        
        while (t != null) {
            if (!isLeaf(t)) {
                s.push(t.val);
            }
            if (t.right != null) {
                t = t.right;
            } else {
                t = t.left;
            }
        }
        
        while (!s.empty()) {
            res.add(s.pop());
        }
        
        return res;
    }

    private void addLeaves(TreeNode root, List<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.val);
        } else {
            if (root.left != null) {
                addLeaves(root.left, res);
            }
            
            if (root.right != null) {
                addLeaves(root.right, res);
            }
        }
    }
    
    private boolean isLeaf(TreeNode t) {
        return t.left == null && t.right == null;
    }
}
