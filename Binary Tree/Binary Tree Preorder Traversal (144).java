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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.empty()) {
            if (root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                TreeNode peek = stack.pop();
                root = peek.right;
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        
        return result;
    }
    
    private void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }
}
