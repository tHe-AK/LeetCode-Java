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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }
    
    private TreeNode construct(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        
        int idx = l;
        
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        
        TreeNode root = new TreeNode(nums[idx]);
        root.left = construct(nums, l, idx - 1);
        root.right = construct(nums, idx + 1, r);
        
        return root;
    }
}
