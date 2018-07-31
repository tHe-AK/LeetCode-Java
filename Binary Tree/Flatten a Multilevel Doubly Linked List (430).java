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
                head = head.child;
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
