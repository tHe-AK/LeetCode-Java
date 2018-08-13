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
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }
    
    private void postorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        
        for (Node child : root.children) {
            postorder(child, list);
        }
        
        list.add(root.val);
    }
}

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
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
            
        if (root == null) {
            return list;
        }
        
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.empty()) {
            Node peek = stack.pop();
            list.add(peek.val);
            
            for (Node child : peek.children) {
                stack.push(child);
            }
        }
        
        Collections.reverse(list);
        return list;
    }
}
