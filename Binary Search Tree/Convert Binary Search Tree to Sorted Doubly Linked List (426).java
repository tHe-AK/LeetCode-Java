class Solution {
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode dummy = new TreeNode(0);
        TreeNode[] prev = new TreeNode[1];
        prev[0] = dummy;

        inorder(root, prev);

        TreeNode head = dummy.right;
        prev[0].right = head;
        head.left = prev[0];

        return head;
    }

    private void inorder(TreeNode root, TreeNode[] prev) {
        if (root == null) {
            return;
        }

        inorder(root.left, prev);
        prev[0].right = root;
        root.left = prev[0];
        prev[0] = root;
        inorder(root.right, prev);
    }
}
