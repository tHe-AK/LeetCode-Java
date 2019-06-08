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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        while (root != null || !stack.empty()) {
            if (root != null) {
                res.add(root.val);
                stack.add(root.left);
                root = root.right;
            } else {
                root = stack.pop();
            }
        }
        
        Collections.reverse(res);
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else if (stack.peek().right != null && stack.peek().right != pre) {
                root = stack.peek().right;
            } else {
                TreeNode peek = stack.pop();
                result.add(peek.val);
                pre = peek;
                root = null;
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        helper(stack, root);
        
        while (!stack.isEmpty()) {
            TreeNode peek = stack.pop();
            res.add(peek.val);
            
            if (!stack.empty() && stack.peek().right != peek) {
                helper(stack, stack.peek().right);
            }
        }
        
        return res;
    }
    
    private void helper(Stack<TreeNode> stack, TreeNode root) {
        while (root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.peek().right;
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
class Solution {
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
