/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        else if (left != null && right != null && left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left)) {
            return true;
        }
        else {
            return false;
        }
    }
}

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.add(root.left);
        q2.add(root.right);
        
        while (q1.isEmpty() == false) {
            TreeNode cur1 = q1.remove();
            TreeNode cur2 = q2.remove();
            
            if (cur1 == null && cur2 == null) {
                continue;
            }
            else if (cur1 != null && cur2 != null && cur1.val == cur2.val) {
                q1.add(cur1.left);
                q2.add(cur2.right);
                q1.add(cur1.right);
                q2.add(cur2.left);
            }
            else {
                return false;
            }
        }
        
        return true;
    }
}
