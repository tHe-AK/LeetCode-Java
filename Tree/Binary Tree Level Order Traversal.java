/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<Integer>();
            
            for (int i = 0; i < size; i++) {
                TreeNode peek = queue.poll();
                level.add(peek.val);
                
                if (peek.left != null) {
                    queue.offer(peek.left);
                }
                
                if (peek.right != null) {
                    queue.offer(peek.right);
                }
            }
            
            result.add(level);
        }
        
        return result;
    }
}