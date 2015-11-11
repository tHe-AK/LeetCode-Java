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
    public List<TreeNode> generateTrees(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        
        List<TreeNode> result = new ArrayList<TreeNode>();

        return helper(1, n);
    }
    
    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> rec = new ArrayList<TreeNode>();
        
        if (start > end) {
            rec.add(null);
            return rec;
        }
        
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = helper(start, i - 1);
            List<TreeNode> right = helper(i + 1, end);
            
            for (int m = 0 ; m < left.size(); m++) {
                for (int n = 0; n < right.size(); n++) {
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(m);
                    root.right = right.get(n);
                    rec.add(root);
                }
            }
        }
        
        return rec;
    }
}