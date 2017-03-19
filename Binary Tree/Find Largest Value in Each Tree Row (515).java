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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        preorder(root, 0, result);
        
        return result;
    }
    
    private void preorder(TreeNode root, int idx, List<Integer> result){
        if (root == null) {
            return;
        }
        
        if (idx == result.size()) {
            result.add(root.val);
        } else {
            result.set(idx, Math.max(result.get(idx), root.val));
        }
        
        preorder(root.left, idx + 1, result);
        preorder(root.right, idx + 1, result);
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            
            for (int i = 0; i < size; i++) {
                TreeNode peek = queue.poll();
                max = Math.max(max, peek.val);
                
                if (peek.left != null) {
                    queue.add(peek.left);
                }
                
                if (peek.right != null) {
                    queue.add(peek.right);
                }
            }
            
            result.add(max);
        }
        
        return result;
    }
}
