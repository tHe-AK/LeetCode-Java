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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        while (root != null || !stack.empty()) {
            if (root != null) {
                result.add(0, root.val);
                stack.add(root);
                root = root.right;
            } else {
                TreeNode peek = stack.pop();
                root = peek.left;
            }
        }
        
        return result;
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        
        return result;
    }
    
    private void postorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }
}
