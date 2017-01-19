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
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    public boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        } else {
            return t1.val == t2.val && isSymmetric(t1.right, t2.left) && isSymmetric(t1.left, t2.right);
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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode peek1 = queue.poll();
            TreeNode peek2 = queue.poll();
            
            if (peek1 == null && peek2 == null) {
                continue;
            } else if (peek1 == null || peek2 == null) {
                return false;
            } else if (peek1.val != peek2.val) {
                return false;
            } else {
                queue.add(peek1.left);
                queue.add(peek2.right);
                queue.add(peek1.right);
                queue.add(peek2.left);
            }
        }
        
        return true;
    }
}
