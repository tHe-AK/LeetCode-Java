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
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.empty()) {
            if (root != null) {
                res.add(root.val);
                stack.push(root.right);
                root = root.left;
            } else {
                root = stack.pop();
            }
        }
        
        return res;
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.empty()) {
            TreeNode peek = stack.pop();
            res.add(peek.val);
            
            if (peek.right != null) {
                stack.push(peek.right);
            }
            
            if (peek.left != null) {
                stack.push(peek.left);
            }
        }
        
        return res;
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
