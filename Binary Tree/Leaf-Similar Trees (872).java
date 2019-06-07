/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        preorder(root1, list1);
        preorder(root2, list2);
        
        return list1.equals(list2);
    }
    
    private void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        
        preorder(root.left, list);
        preorder(root.right, list);
    }
}
