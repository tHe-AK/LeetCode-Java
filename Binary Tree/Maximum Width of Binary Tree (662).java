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
    public int widthOfBinaryTree(TreeNode root) {
        return widthOfBinaryTree(root, 0, 1, new ArrayList<>(), new ArrayList<>());
    }
    
    private int widthOfBinaryTree(TreeNode root, int level, int idx, List<Integer> start, List<Integer> end) {
        if (root == null) {
            return 0;
        }
        
        if (level == start.size()) {
            start.add(idx);
            end.add(idx);
        } else {
            end.set(level, idx);
        }
        
        int curr = end.get(level) - start.get(level) + 1;
        int left = widthOfBinaryTree(root.left, level + 1, idx * 2, start, end);
        int right = widthOfBinaryTree(root.right, level + 1, idx * 2 + 1, start, end);

        return Math.max(Math.max(left, right), curr);
    }
}
