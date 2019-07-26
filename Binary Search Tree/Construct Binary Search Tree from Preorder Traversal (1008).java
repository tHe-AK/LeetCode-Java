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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int mid = start + 1;
        
        while (mid <= end && preorder[mid] < preorder[start]) {
            mid++;
        }
        
        TreeNode root = new TreeNode(preorder[start]);
        root.left = helper(preorder, start + 1, mid - 1);
        root.right = helper(preorder, mid, end);
        return root;
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
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MAX_VALUE, new int[1]);
    }
    
    private TreeNode helper(int[] preorder, int max, int[] idx) {
        if (idx[0] == preorder.length || preorder[idx[0]] > max) {
            return null;
        }
        
        int val = preorder[idx[0]++];
        TreeNode root = new TreeNode(val);
        root.left = helper(preorder, val, idx);
        root.right = helper(preorder, max, idx);
        return root;
    }
}
