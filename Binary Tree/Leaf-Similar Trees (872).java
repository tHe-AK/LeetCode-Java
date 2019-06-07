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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        preorder(root1, list1);
        preorder(root2, list2);
        
        return list1.equals(list2);
    }
    
    private void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        
        preorder(root.left, list);
        preorder(root.right, list);
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root1);
        stack2.push(root2);
        
        while (!stack1.empty() && !stack2.empty()) {
            if (preorder(stack1) != preorder(stack2)) {
                return false;
            }
        }
        
        return stack1.empty() && stack2.empty();
    }
    
    private int preorder(Stack<TreeNode> stack) {        
        while (!stack.empty()) {
            TreeNode root = stack.pop();
            
            if (root.left == null && root.right == null) {
                return root.val;
            }
            
            if (root.right != null) {
                stack.push(root.right);
            }
                
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        
        return 0;
    }
}
