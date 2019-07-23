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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isX = false;
            boolean isY = false;
            
            while (size-- > 0) {
                TreeNode peek = queue.poll();
                
                if (peek.val == x) {
                    isX = true;
                } else if (peek.val == y) {
                    isY = true;
                }
                
                if (peek.left != null && peek.right != null) {
                    if ((peek.left.val == x && peek.right.val == y) || (peek.left.val == y && peek.right.val == x)) {
                        return false;
                    }
                }
                
                if (peek.left != null) {
                    queue.offer(peek.left);
                }
                
                if (peek.right != null) {
                    queue.offer(peek.right);
                }
            }
            
            if (isX && isY) {
                return true;
            } else if (isX || isY) {
                return false;
            }
        }
        
        return false;
    }
}
