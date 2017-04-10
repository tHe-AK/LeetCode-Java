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
    public int longestConsecutive(TreeNode root) {
        int[] max = new int[1];
        postorder(root, max);
        return max[0];
    }
    
    private int postorder(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        
        int inc = 1;
        int left = postorder(root.left, max);
        int right = postorder(root.right, max);
        
        if (root.left != null && root.val == root.left.val - 1) {
            inc = left + 1;
        }
        
        if (root.right != null && root.val == root.right.val - 1) {
            inc = Math.max(inc, right + 1);
        }
        
        max[0] = Math.max(max[0], inc);
        return inc;
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
    public int longestConsecutive(TreeNode root) {
        return longestConsecutive(root, null, 0);
    }

    private int longestConsecutive(TreeNode root, TreeNode parent, int len) {
        if (root == null) {
            return len;
        }
        
        len = (parent != null && root.val == parent.val + 1) ? len + 1 : 1;
        
        return Math.max(len, Math.max(longestConsecutive(root.left, root, len), longestConsecutive(root.right, root, len)));
    }
}
