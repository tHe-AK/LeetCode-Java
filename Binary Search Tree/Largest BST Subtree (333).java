/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class SubTree {
    public int size;
    public long min;
    public long max;
     
    public SubTree(int size, long min, long max) {
        this.size = size;
        this.min = min;
        this.max = max;
    }
}

public class Solution {
    public int largestBSTSubtree(TreeNode root) {
        int[] max = new int[1];
        traverse(root, max);
        
        return max[0];
    }
    
    private SubTree traverse(TreeNode root, int[] max) {
        if (root == null) {
            return new SubTree(0, Long.MAX_VALUE, Long.MIN_VALUE);
        }
        
        SubTree left = traverse(root.left, max);
        SubTree right = traverse(root.right, max);
        
        if (left.size == -1 || right.size == -1 || root.val <= left.max || root.val >= right.min) {
            return new SubTree(-1, 0, 0);
        }
        
        int size = left.size + right.size + 1;
        max[0] = Math.max(max[0], size);
        
        return new SubTree(size, Math.min(left.min, root.val), Math.max(right.max, root.val));
    }
}
