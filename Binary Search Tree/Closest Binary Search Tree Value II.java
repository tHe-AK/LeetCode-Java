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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();

        inorder(root, target, k, result);
        
        return result;
    }
    
    private void inorder(TreeNode root, double target, int k, List<Integer> result) {
        if (root == null) {
            return;
        }
        
        inorder(root.left, target, k, result);
        
        if (result.size() == k) {
            if (Math.abs(root.val - target) < Math.abs(result.get(0) - target)) {
                result.remove(0);
            } else {
                return;
            }
        }
        
        result.add(root.val);
        inorder(root.right, target, k, result);
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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> predecessor = new Stack<>();
        Stack<TreeNode> successor = new Stack<>();
        
        while (root != null) {
            if (root.val < target) {
                predecessor.push(root);
                root = root.right;
            } else {
                successor.push(root);
                root = root.left;
            }
        }
        
        while (k-- > 0) {
            if (successor.empty()) {
                result.add(popPredecessor(predecessor));
            } else if (predecessor.empty()) {
                result.add(popSuccessor(successor));
            } else {
                if (Math.abs(predecessor.peek().val - target) < Math.abs(successor.peek().val - target)) {
                    result.add(popPredecessor(predecessor));
                } else {
                    result.add(popSuccessor(successor));
                }
            }
        }
        
        return result;
    }
    
    private int popSuccessor(Stack<TreeNode> successor) {
        TreeNode peek = successor.pop();
        TreeNode node = peek.right;
        
        while (node != null) {
            successor.push(node);
            node = node.left;
        }
        
        return peek.val;
    }
    
    private int popPredecessor(Stack<TreeNode> predecessor) {
        TreeNode peek = predecessor.pop();
        TreeNode node = peek.left;
        
        while (node != null) {
            predecessor.push(node);
            node = node.right;
        }
        
        return peek.val;
    }
}
