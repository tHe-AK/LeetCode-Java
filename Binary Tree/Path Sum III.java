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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        
        return traverse(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int traverse(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        
        return (root.val == sum ? 1 : 0) + traverse(root.left, sum - root.val) + traverse(root.right, sum - root.val);
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
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        return traverse(root, sum, 0, map);
    }
    
    private int traverse(TreeNode root, int sum, int curr, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        
        curr += root.val;
        int count = map.getOrDefault(curr - sum, 0);
        
        map.put(curr, map.getOrDefault(curr, 0) + 1);
        count += traverse(root.left, sum, curr, map) + traverse(root.right, sum, curr, map);
        map.put(curr, map.get(curr) - 1);
        
        return count;
    }
}
