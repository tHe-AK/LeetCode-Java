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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        
        ArrayList<Integer> rec = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode pre = null;
        
        while (cur != null || !s.empty()) {
            if (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            else if (s.peek().right != null && s.peek().right != pre) {
                cur = s.peek().right;
            }
            else {
                rec.add(s.peek().val);
                pre = s.peek();
                cur = null;
                s.pop();
            }
        }
        
        return rec;
    }
}
