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
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }
    
    private void preorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        
        list.add(root.val);
        
        for (Node child : root.children) {
            preorder(child, list);
        }
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
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        
        if (root == null) {
            return list;
        }
        
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.empty()) {
            Node peek = stack.pop();
            list.add(peek.val);
            
            for (int i = peek.children.size() - 1; i >= 0; i--) {
                stack.push(peek.children.get(i));
            }
        }
        
        return list;
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
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        
        while (root != null || !stack.empty()) {
            if (root != null) {
                list.add(root.val);
                
                if (root.children.isEmpty()) {
                    root = null;
                } else {
                    for (int i = root.children.size() - 1; i > 0; i--) {
                        stack.push(root.children.get(i));
                    }
                    
                    root = root.children.get(0);
                }
            } else {
                root = stack.pop();
            }
        }
        
        return list;
    }
}
