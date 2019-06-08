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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode peek = stack.pop();
                result.add(peek.val);
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
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        helper(stack, root);
        
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            helper(stack, node.right);
        }
        
        return res;
    }
    
    private void helper(Stack<TreeNode> stack, TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        
        return result;
    }
    
    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
}
