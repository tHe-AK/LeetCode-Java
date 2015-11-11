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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        else if (left == null || right == null) {
            return false;
        }
        else {
            return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
        }
    }
}

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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.offer(root.left);
        queue2.offer(root.right);
        
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode peek1 = queue1.poll();
            TreeNode peek2 = queue2.poll();
            
            if (peek1 == null && peek2 == null) {
                continue;
            }
            else if (peek1 == null || peek2 == null) {
                return false;
            }
            else if (peek1.val != peek2.val) {
                return false;
            }
            else {
                queue1.add(peek1.left);
                queue1.add(peek1.right);
                queue2.add(peek2.right);
                queue2.add(peek2.left);
            }
        }
        
        return true;
    }
}