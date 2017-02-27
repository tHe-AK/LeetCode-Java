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
    public int sumOfLeftLeaves(TreeNode root) {
        return traverse(root, false);
    }
    
    private int traverse(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null && isLeft) {
            return root.val;
        } else {
            return traverse(root.left, true) + traverse(root.right, false);
        }
    }
}

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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode peek = queue.poll();
            
            if (peek.left != null && peek.left.left == null && peek.left.right == null) {
                result += peek.left.val;
            }
                
            if (peek.left != null) {
                queue.offer(peek.left);
            }
                
            if (peek.right != null) {
                queue.offer(peek.right);
            }
        }
        
        return result;
    }
}
