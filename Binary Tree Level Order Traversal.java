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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result; 
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (q.isEmpty() == false) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode cur = q.peek();
                q.poll();
                level.add(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            result.add(level);
        }
        
        return result;
    }
}
