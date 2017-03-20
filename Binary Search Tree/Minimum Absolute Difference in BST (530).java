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
    public int getMinimumDifference(TreeNode root) {
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        
        inorder(root, new Integer[1], min);
        
        return min[0];
    }
    
    private void inorder(TreeNode root, Integer[] prev, int[] min) {
        if (root == null) {
            return;
        }
        
        inorder(root.left, prev, min);
        
        if (prev[0] != null) {
            min[0] = Math.min(min[0], root.val - prev[0]);
        }
        
        prev[0] = root.val;
        inorder(root.right, prev, min);
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
    public int getMinimumDifference(TreeNode root) {
        TreeSet<Integer> set = new TreeSet<>();
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        
        preorder(root, set, min);
        
        return min[0];
    }
    
    private void preorder(TreeNode root, TreeSet<Integer> set, int[] min) {
        if (root == null) {
            return;
        }
        
        Integer floor = set.floor(root.val);
        Integer ceiling = set.ceiling(root.val);
        
        if (floor != null) {
            min[0] = Math.min(min[0], Math.abs(root.val - floor));
        }
        
        if (ceiling != null) {
            min[0] = Math.min(min[0], Math.abs(root.val - ceiling));
        }
        
        set.add(root.val);
        preorder(root.left, set, min);
        preorder(root.right, set, min);
    }
}
