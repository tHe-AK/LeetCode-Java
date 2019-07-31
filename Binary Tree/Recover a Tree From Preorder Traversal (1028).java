/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode recoverFromPreorder(String S) {
        Stack<TreeNode> stack = new Stack<>();
        int N = S.length();
        int i = 0;
        
        while (i < N) {
            int height = 0;
            
            while (i < N && S.charAt(i) == '-') {
                height++;
                i++;
            }
            
            int val = 0;
            
            while (i < N && Character.isDigit(S.charAt(i))) {
                val = val * 10 + (S.charAt(i++) - '0');
            }
                        
            while (stack.size() > height) {
                stack.pop();
            }
            
            TreeNode node = new TreeNode(val);
            
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }
            
            stack.add(node);
        }
        
        while (stack.size() > 1) {
            stack.pop();
        }
        
        return stack.pop();
    }
}
