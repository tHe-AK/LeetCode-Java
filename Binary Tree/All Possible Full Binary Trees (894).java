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
    public List<TreeNode> allPossibleFBT(int N) {
        return postorder(N, new HashMap<Integer, List<TreeNode>>());
    }
    
    private List<TreeNode> postorder(int N, Map<Integer, List<TreeNode>> map) {
        if (map.containsKey(N)) {
            return map.get(N);
        }
        
        List<TreeNode> list = new ArrayList<>();

        if (N == 1) {
            list.add(new TreeNode(0));
        } else if (N % 2 == 1) {
            for (int i = 1; i < N - 1; i += 2) {
                List<TreeNode> left = postorder(i, map);
                List<TreeNode> right = postorder(N - i - 1, map);
                
                for (TreeNode node1 : left) {
                    for (TreeNode node2 : right) {
                        TreeNode root = new TreeNode(0);
                        root.left = node1;
                        root.right = node2;
                        list.add(root);
                    }
                }
            }
        }
        
        map.put(N, list);
        return list;
    }
}
