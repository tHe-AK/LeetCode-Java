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
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] max = new int[1];
        List<Integer> list = new ArrayList<>();
        
        inorder(root, map, max);
        
        for (int key : map.keySet()) {
            if (map.get(key) == max[0]) {
                list.add(key);
            }
        }
        
        int[] result = new int[list.size()];
        
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
    
    private void inorder(TreeNode root, Map<Integer, Integer> map, int[] max) {
        if (root == null) {
            return;
        }
        
        inorder(root.left, map, max);
        
        int count = map.getOrDefault(root.val, 0) + 1;
        map.put(root.val, count);
        max[0] = Math.max(max[0], count);
        
        inorder(root.right, map, max);
    }
}
