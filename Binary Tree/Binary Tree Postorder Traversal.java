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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode pre = null;
        
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            else if (stack.peek().right != null && stack.peek().right != pre) {
                cur = stack.peek().right;
            }
            else {
                TreeNode peek = stack.pop();
                result.add(peek.val);
                pre = peek;
                cur = null;
            }
        }
        
        return result;
    }
}