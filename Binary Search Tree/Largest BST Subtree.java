/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Result {
    int size;
    int min;
    int max;
     
    Result(int size, int min, int max) {
        this.size = size;
        this.min = min;
        this.max = max;
    }
}
 
public class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int[] max = new int[1];
        helper(root, max);
        
        return max[0];
    }
    
    private Result helper(TreeNode root, int[] max) {
        if (root == null) {
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        Result left = helper(root.left, max);
        Result right = helper(root.right, max);
        
        if (left.size == -1 || right.size == -1 || left.max >= root.val || root.val >= right.min) {
            return new Result(-1, 0, 0);
        }
        
        int size = left.size + right.size + 1;
        max[0] = Math.max(max[0], size);
        
        return new Result(size, Math.min(root.val, Math.min(left.min, right.min)), Math.max(root.val, Math.max(left.max, right.max)));
    }
}
