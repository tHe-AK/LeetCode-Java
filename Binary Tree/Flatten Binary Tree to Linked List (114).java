/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        
        Node dummy = new Node();
        Node prev = dummy;
        Stack<Node> stack = new Stack<>();
        
        while (head != null || !stack.empty()) {
            if (head != null) {
                prev.next = head;
                head.prev = prev;
                stack.push(head.next);
                prev = head;
                head = prev.child;
                prev.child = null;
            } else {
                head = stack.pop();
            }
        }
        
        head = dummy.next;
        head.prev = null;
        return head;
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        
        Node dummy = new Node();
        Node[] prev = new Node[1];
        prev[0] = dummy;
        
        preorder(head, prev);
        
        head = dummy.next;
        head.prev = null;
        return head;
    }
    
    private void preorder(Node head, Node[] prev) {
        if (head == null) {
            return;
        }
        
        prev[0].next = head;
        head.prev = prev[0];
        prev[0] = head;
        Node next = head.next;
        
        preorder(head.child, prev);
        head.child = null;
        preorder(next, prev);
    }
}
