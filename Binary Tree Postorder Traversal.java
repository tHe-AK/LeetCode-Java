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
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode pre = null;
        
        while (cur != null || stack.empty() == false) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            else if (stack.peek().right != null && stack.peek().right != pre) {
                cur = stack.peek().right;
            }
            else {
                TreeNode peek = stack.peek();
                stack.pop();
                result.add(peek.val);
                pre = peek;
                cur = null;
            }
        }
        
        return result;
    }
}
