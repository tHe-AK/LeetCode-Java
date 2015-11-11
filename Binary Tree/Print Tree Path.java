public class Solution {
    public void printTreePath(TreeNode root) {
        if (root == null) {
            return;
        }
        
        helper(root, "");
    }
    
    private void helper(TreeNode root, String cur) {
        if (root == null) {
            return;
        }
        
        cur += root.val + " ";
        
        if (root.left == null && root.right == null) {
            System.out.println(cur);
            
            return;
        }
        
        helper(root.left, cur);
        helper(root.right, cur);
    }
}