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

    public void insert(int val) {
        root = insert(root, val);
    }

    private TreeNode insert(TreeNode p, int val) {
        if (p == null) {
            return new TreeNode(val);
        }

        if (p.val == val) {
            throw new RuntimeException("Can not insert");
        } else if (p.val < val) {
            p.right = insert(p.right, val);
        } else {
            p.left = insert(p.left, val);
        }

        return p;
    }

    public TreeNode LeastCommonAncestor(TreeNode x, TreeNode y) {
        if (x == null || y == null) {
            return null;
        }

        return helper(root, x, y);
    }

    private TreeNode helper(TreeNode p, TreeNode x, TreeNode y) {
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
            return p;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        s.insert(4);
        s.insert(2);
        s.insert(6);
        s.insert(1);
        s.insert(3);
        s.insert(5);
        s.insert(7);
        
        System.out.println(s.LeastCommonAncestor(s.root.left, s.root.right).val);
    }
}
