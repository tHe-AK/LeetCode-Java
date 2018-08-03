class Solution {
    public TreeNode encode(Node root) {
        if (root == null) {
            return null;
        }
        
        List<Node> list = new LinkedList<>();
        list.add(root);
        return encode(list);
    }
    
    private TreeNode encode(List<Node> list) {
        if (list.isEmpty()) {
            return null;
        }
        
        Node node = list.remove(0);
        TreeNode root = new TreeNode(node.val);
        root.left = encode(list);
        root.right = encode(node.children);
        return root;
    }
    
    public Node decode(TreeNode root) {        
        if (root == null) {
            return null;
        }
        
        return decode(root, null);
    }
    
    private Node decode(TreeNode root, Node parent) {
        if (root == null) {
            return null;
        }
        
        Node node = new Node(root.val, new ArrayList<>());
        
        if (parent != null) {
            parent.children.add(node);
        }
        
        decode(root.left, parent);
        decode(root.right, node);
        return node;
    }
}
