/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public String serialize(Node root) {
        if (root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    private void serialize(Node root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        
        sb.append(root.val + " ");
        
        for (Node child : root.children) {
            serialize(child, sb);
        }
        
        sb.append("# ");
    }
    
    public Node deserialize(String str) {        
        if (str.isEmpty()) {
            return null;
        }
        
        return deserialize(Arrays.asList(str.split(" ")).iterator());
    }
    
    private Node deserialize(Iterator<String> it) {
        String str = it.next();
        
        if (str.equals("#")) {
            return null;
        }
        
        Node root = new Node(Integer.parseInt(str), new ArrayList<>());
        Node child = deserialize(it);
        
        while (child != null) {
            root.children.add(child);
            child = deserialize(it);
        }
        
        return root;
    }
}
