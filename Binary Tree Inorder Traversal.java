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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        while (stack.empty() == false || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            else {
                TreeNode peek = stack.peek();
                stack.pop();
                result.add(peek.val);
                cur = peek.right;
            }
        }
        
        return result;
    }
}
