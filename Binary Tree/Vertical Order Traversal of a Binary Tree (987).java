/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Map<Integer, Queue<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        
        for (Integer x : map.keySet()) {
            List<Integer> list = new ArrayList<>();
            
            for (Integer y : map.get(x).keySet()) {
                Queue<Integer> queue =  map.get(x).get(y);
                
                while (!queue.isEmpty()) {
                    list.add(queue.poll());
                }
            }
            
            res.add(list);
        }
        
        return res;
    }
    
    private void dfs(TreeNode root, int x, int y, Map<Integer, Map<Integer, Queue<Integer>>> map) {
        if (root == null) {
            return;
        }
        
        map.putIfAbsent(x, new TreeMap<>());
        Map<Integer, Queue<Integer>> val = map.get(x);
        val.putIfAbsent(y, new PriorityQueue<>());
        val.get(y).offer(root.val);
        
        dfs(root.left, x - 1, y + 1, map);
        dfs(root.right, x + 1, y + 1, map);
    }
}
