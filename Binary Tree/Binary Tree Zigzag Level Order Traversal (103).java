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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        preorder(root, 0, result);
        
        return result;
    }
    
    private void preorder(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        
        if (result.size() == level) {
            result.add(new LinkedList<Integer>());
        }
        
        List<Integer> list = result.get(level);
        list.add(level % 2 == 0 ? list.size() : 0, root.val);
        
        preorder(root.left, level + 1, result);
        preorder(root.right, level + 1, result);
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new LinkedList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode peek = queue.poll();
                level.add(reverse ? 0 : level.size(), peek.val);
                
                if (peek.left != null) {
                    queue.add(peek.left);
                }
                
                if (peek.right != null) {
                    queue.add(peek.right);
                }
            }
            
            reverse = !reverse;
            result.add(level);
        }
        
        return result;
    }
}
