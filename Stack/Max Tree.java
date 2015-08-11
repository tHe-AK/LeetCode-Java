/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        
        int len = A.length;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        for (int i = 0; i < len; i++) {
            TreeNode cur = new TreeNode(A[i]);
            
            while (!stack.empty() && A[i] > stack.peek().val) {
                cur.left = stack.peek();
                stack.pop();
            }
            
            if (!stack.empty()) {
                stack.peek().right = cur;
            }
            
            stack.push(cur);
        }
        
        while (stack.size() > 1) {
            stack.pop();
        }
        
        return stack.peek();
    }
}
