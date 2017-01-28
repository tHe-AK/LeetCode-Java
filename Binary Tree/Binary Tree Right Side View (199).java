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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        preorder(root, 0, result);
        
        return result;
    }
    
    private void preorder(TreeNode root, int level, List<Integer> result) {
        if (root == null) {
            return;
        }
        
        if (level == result.size()) {
            result.add(root.val);
        }
        
        preorder(root.right, level + 1, result);
        preorder(root.left, level + 1, result);
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode peek = queue.poll();
                
                if (i == size - 1) {
                    result.add(peek.val);
                }
                
                if (peek.left != null) {
                    queue.offer(peek.left);
                }
                
                if (peek.right != null) {
                    queue.offer(peek.right);
                }
            }
        }
        
        return result;
    }
}
