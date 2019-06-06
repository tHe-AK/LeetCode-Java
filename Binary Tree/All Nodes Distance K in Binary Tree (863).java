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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        preorder(root, null, map);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(target.val);
        visited.add(target.val);
        
        for (int k = 0; k < K; k++) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int peek = queue.poll();
                
                for (Integer j : map.get(peek)) {
                    if (visited.add(j)) {
                        queue.offer(j);
                    }
                }
            }
        }
        
        return new ArrayList<>(queue);
    }
    
    private void preorder(TreeNode root, Integer prev, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }
        
        int curr = root.val;
        map.putIfAbsent(curr, new ArrayList<>());

        if (prev != null) {
            map.get(curr).add(prev);
            map.get(prev).add(curr);
        }
        
        preorder(root.left, curr, map);
        preorder(root.right, curr, map);
    }
}
