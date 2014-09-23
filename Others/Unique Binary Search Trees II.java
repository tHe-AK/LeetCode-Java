/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        if (n < 0) {
            return new ArrayList<TreeNode>();
        }
        
        return helper(1, n);
    }
    
    private ArrayList<TreeNode> helper(int start, int end) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end) {
            result.add(null);
            return result;
        }
        
        for (int i = start; i <= end; i++) {
            ArrayList<TreeNode> left = helper(start, i - 1);
            ArrayList<TreeNode> right = helper(i + 1, end);
            for (int x = 0; x < left.size(); x++) {
                for (int y = 0; y < right.size(); y++) {
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(x);
                    root.right = right.get(y);
                    result.add(root);
                }
            }
        }
        
        return result;
    }
}
