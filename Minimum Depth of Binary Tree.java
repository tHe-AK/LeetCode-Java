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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int depth = 0;
        while (true) {
            depth++;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode cur = q.peek();
                q.poll();
                
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
    }
}
