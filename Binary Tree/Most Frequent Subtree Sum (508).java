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
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] max = new int[1];
        
        postorder(root, map, max);
        
        List<Integer> list = new ArrayList<>();
        
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
    
    private int postorder(TreeNode root, Map<Integer, Integer> map, int[] max) {
        if (root == null) {
            return 0;
        }
        
        int sum = postorder(root.left, map, max) + postorder(root.right, map, max) + root.val;
        int count = map.getOrDefault(sum, 0) + 1;
        map.put(sum, count);
        max[0] = Math.max(max[0], count);
        
        return sum;
    }
}
