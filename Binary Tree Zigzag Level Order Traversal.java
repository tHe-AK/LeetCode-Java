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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<ArrayList<Integer>>();
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> level = new LinkedList<TreeNode>();
        level.offer(root);
        boolean flag = false;
        
        while (level.isEmpty() == false) {
            ArrayList<Integer> cur = new ArrayList<Integer>();
            int size = level.size();
            for (int i = 0; i < size; i++) {
                TreeNode peek = level.peek();
                level.poll();
                cur.add(peek.val);
                if (peek.left != null) {
                    level.offer(peek.left);
                }
                if (peek.right != null) {
                    level.offer(peek.right);
                }
            }
            
            if (flag == true) {
                Collections.reverse(cur);
            }
            
            result.add(new ArrayList<Integer>(cur));
            flag = !flag;
        }
        
        return result;
    }
}
