/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class CBTInserter {
    TreeNode root;
    Queue<TreeNode> tree;

    public CBTInserter(TreeNode root) {
        this.root = root;
        tree = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode peek = queue.poll();
            
            if (peek.left == null || peek.right == null) {
                tree.offer(peek);
            }
            
            if (peek.left != null) {
                queue.offer(peek.left);
            }
            
            if (peek.right != null) {
                queue.offer(peek.right);
            }
        }
    }
    
    public int insert(int v) {
        TreeNode child = new TreeNode(v);
        TreeNode parent = tree.peek();
        
        if (parent.left == null) {
            parent.left = child;
        } else {
            parent.right = child;
            tree.poll();
        }
        
        tree.offer(child);
        return parent.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */
