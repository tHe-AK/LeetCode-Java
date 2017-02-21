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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        getHeight(root, result);
        return result;
    }
    
    private int getHeight(TreeNode root, List<List<Integer>> result){
        if (root == null) {
            return -1;
        }
        
        int height = Math.max(getHeight(root.left, result), getHeight(root.right, result)) + 1;
        
        if (height >= result.size()) {
            result.add(new ArrayList<>());
        }
        
        result.get(height).add(root.val);
        
        return height;
    }
}
