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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int N = pre.length;
        int[] idx = new int[N + 1];
        
        for (int i = 0; i < N; i++) {
            idx[post[i]] = i;
        }
                
        return helper(pre, post, idx, 0, N - 1, 0, N - 1);
    }
    
    private TreeNode helper(int[] pre, int[] post, int[] idx, int preStart, int preEnd, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(pre[preStart]);
        
        if (preStart + 1 <= preEnd) {
            int i = idx[pre[preStart + 1]];
            root.left = helper(pre, post, idx, preStart + 1, preStart + 1 + i - postStart, postStart, i);
            root.right = helper(pre, post, idx, preStart + 1 + i - postStart + 1, preEnd, i + 1, postEnd - 1);
        }
        
        return root;
    }
}
