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
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        String[][] rec = new String[height][(1 << height) - 1];
        List<List<String>> res = new ArrayList<>();

        for (String[] row : rec) {
            Arrays.fill(row, "");
        }
        
        fill(root, 0, 0, rec[0].length, rec);
        
        for (String[] row : rec) {
            res.add(Arrays.asList(row));
        }
            
        return res;
    }
    
    private void fill(TreeNode root, int i, int l, int r, String[][] rec) {
        if (root == null) {
            return;
        }
        
        int mid = (l + r) / 2;
        rec[i][mid] = "" + root.val;
        fill(root.left, i + 1, l, mid - 1, rec);
        fill(root.right, i + 1, mid + 1, r, rec);
    }
    
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
