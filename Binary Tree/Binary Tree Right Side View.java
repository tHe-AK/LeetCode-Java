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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode peek = queue.poll();
                
                if (i == size - 1) {
                    result.add(peek.val);
                }
                
                if (peek.left != null) {
                    queue.offer(peek.left);
                }
                
                if (peek.right != null) {
                    queue.offer(peek.right);
                }
            }
        }
        
        return result;
    }
}
