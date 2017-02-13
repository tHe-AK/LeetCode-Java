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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        queue.offer(root);
        cols.offer(0);
        int min = 0;
        int max = 0;
        
        while (!queue.isEmpty()) {
            TreeNode peek = queue.poll();
            int col = cols.poll();
            min = Math.min(min, col);
            max = Math.max(max, col);
            
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            
            map.get(col).add(peek.val);

            if (peek.left != null) {
                queue.offer(peek.left);
                cols.offer(col - 1);
            }
            
            if (peek.right != null) {
                queue.offer(peek.right);
                cols.offer(col + 1);
            }
        }
        
        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        }
        
        return result;
    }
}
