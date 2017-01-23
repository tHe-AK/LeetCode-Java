class ListNode {
    int key;
    int value;
    ListNode pre;
    ListNode next;
    
    ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    private HashMap<Integer, ListNode> rec;
    private ListNode head;
    private ListNode tail;
    private int capacity;
    
    public LRUCache(int capacity) {
        rec = new HashMap<Integer, ListNode>();
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (rec.containsKey(key)) {
            ListNode curr = rec.get(key);
            remove(curr);
            shift(curr);
            return curr.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (rec.containsKey(key)) {
            ListNode curr = rec.get(key);
            curr.value = value;
            remove(curr);
            shift(curr);
        } else {
            if (rec.size() == capacity) {
                ListNode curr = tail.pre;
                remove(curr);
                rec.remove(curr.key);
            }
            
            ListNode curr = new ListNode(key, value);
            shift(curr);
            rec.put(key, curr);
        }
    }
    
    private void remove(ListNode curr) {
        ListNode pre = curr.pre;
        ListNode next = curr.next;
        pre.next = next;
        next.pre = pre;
    }
    
    private void shift(ListNode curr) {
        ListNode next = head.next;
        head.next = curr;
        curr.next = next;
        next.pre = curr;
        curr.pre = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
