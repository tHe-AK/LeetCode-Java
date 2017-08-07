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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet();
        return preorder(root, k, set);
    }
    
    public boolean preorder(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        
        if (set.contains(k - root.val)) {
            return true;
        }
        
        set.add(root.val);
        return preorder(root.left, k, set) || preorder(root.right, k, set);
    }
}
