class MyLinkedList {
    private class ListNode {
        public int val;
        public ListNode next;
        
        public ListNode(int val) {
            this.val = val;
        }
    }
    
    private ListNode head;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
        size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        
        if (index == 0) {
            return head.val;
        } else {
            ListNode prev = getPrev(index);
            return prev.next.val;
        }
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        
        ListNode node = new ListNode(val);
        
        if (index == 0) {
            if (head != null) {
                node.next = head;
            }
            
            head = node;
        } else {
            ListNode prev = getPrev(index);
            node.next = prev.next;
            prev.next = node;
        }
        
        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        
        if (index == 0) {
            head = head.next;
        } else {
            ListNode prev = getPrev(index);
            prev.next = prev.next.next;
        }
        
        size--;
    }
    
    private ListNode getPrev(int index) {
        if (index == 0) {
            return null;
        }
        
        ListNode prev = head;
        
        while (index > 1) {
            prev = prev.next;
            index--;
        }
        
        return prev;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
