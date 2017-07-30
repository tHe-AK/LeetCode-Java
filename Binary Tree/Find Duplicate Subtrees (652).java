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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        preorder(root, map, res);
        
        return res;
    }
    
    private String preorder(TreeNode root, Map<String, Integer> map, List<TreeNode> res) {
        if (root == null) {
            return "#";
        }
        
        String str = root.val + " " + preorder(root.left, map, res) + " " + preorder(root.right, map, res);
        int count = map.getOrDefault(str, 0);
        
        if (count == 1) {
            res.add(root);
        }
        
        map.put(str, count + 1);
        
        return str;
    }
}
