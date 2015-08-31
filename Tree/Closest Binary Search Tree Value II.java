/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<Integer> predecessor = new Stack<Integer>();
        Stack<Integer> successor = new Stack<Integer>();
        
        helper(root, false, target, predecessor);
        helper(root, true, target, successor);
        
        int i = 1;
        
        while (i <= k) {
            if (predecessor.empty()) {
                result.add(successor.pop());
            } else if (successor.empty()) {
                result.add(predecessor.pop());
            } else {
                if (Math.abs(predecessor.peek() - target) < Math.abs(successor.peek() - target)) {
                    result.add(predecessor.pop());
                } else {
                    result.add(successor.pop());
                }
            }
            
            i++;
        }
        
        return result;
    }
    
    private void helper(TreeNode root, boolean reverse, double target, Stack<Integer> stack) {
        if (root == null) {
            return;
        }
        
        helper(!reverse ? root.left : root.right, reverse, target, stack);
        
        if ((!reverse && root.val > target) || (reverse && root.val <= target)) {
            return;
        }
        
        stack.add(root.val);
        helper(!reverse ? root.right : root.left, reverse, target, stack);
    }
}
