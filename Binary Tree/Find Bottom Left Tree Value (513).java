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
    public int findBottomLeftValue(TreeNode root) {
        TreeNode result = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            result = queue.poll();
            
            if (result.right != null) {
                queue.add(result.right);
            }
            
            if (result.left != null) {
                queue.add(result.left);
            }
        }
        
        return result.val;
    }
}
