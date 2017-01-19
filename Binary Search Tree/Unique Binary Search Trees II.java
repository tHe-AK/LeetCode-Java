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
    public List<TreeNode> generateTrees(int n) {
        return search(1, n);
    }
    
    private void search(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        
        if (start > end) {
            list.add(null);
            return list;
        }
        
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = search(start, i - 1);
            List<TreeNode> right = search(i + 1, end);
            
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    list.add(root);
                }
            }
        }
        
        return list;
    }
}
