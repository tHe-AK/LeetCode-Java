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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.peek() != null) {
            TreeNode peek = queue.poll();
            queue.offer(peek.left);
            queue.offer(peek.right);
        }
            
        while (!queue.isEmpty() && queue.peek() == null) {
            queue.poll();
        }
        
        return queue.isEmpty();
    }
}
