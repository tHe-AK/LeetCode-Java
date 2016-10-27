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
        
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int helper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        
        return (root.val == sum ? 1 : 0) + helper(root.left, sum - root.val) + helper(root.right, sum - root.val);
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
        if (root == null) {
            return 0;
        }
        
        Map<Integer, Integer> rec = new HashMap<Integer, Integer>();
        rec.put(0, 1);
        
        return helper(root, sum, 0, rec);
    }
    
    private int helper(TreeNode root, int sum, int cur, Map<Integer, Integer> rec) {
        if (root == null) {
            return 0;
        }
        
        cur += root.val;
        int count = rec.getOrDefault(cur - sum, 0);
        rec.put(cur, rec.getOrDefault(cur, 0) + 1);
        
        count += helper(root.left, sum, cur, rec) + helper(root.right, sum, cur, rec);
        
        rec.put(cur, rec.get(cur) - 1);
        
        return count;
    }
}
