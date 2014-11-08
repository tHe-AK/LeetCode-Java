class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    private TreeNode root;

    public TreeNode LeastCommonAncestor(TreeNode x, TreeNode y) {
        if (x == null || y == null) {
            return null;
        }

        boolean[] flag = new boolean[1];

        TreeNode root = helper(root, x, y, flag);

        if (flag[0]) {
            return root;
        }
        else {
            return null;
        }
    }

    private TreeNode helper(TreeNode p, TreeNode x, TreeNode y, boolean[] flag) {
        if (p == null || p == x || p == y) {
            return p;
        }

        TreeNode left = helper(p.left, x, y);
        TreeNode right = helper(p.right, x, y);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            flag[0] = true;
            
            return p;
        }
    }
}
