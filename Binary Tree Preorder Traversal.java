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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (s.empty() == false) {
            TreeNode cur = s.peek();
            s.pop();
            result.add(cur.val);
            
            if (cur.right != null) {
                s.push(cur.right);
            }
            if (cur.left != null) {
                s.push(cur.left);
            }
        }
        
        return result;
    }
}
