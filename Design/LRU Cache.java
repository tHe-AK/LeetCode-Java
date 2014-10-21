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
            ListNode cur = rec.get(key);
            remove(cur);
            shift(cur);
            return cur.value;
        }
        else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if (rec.containsKey(key)) {
            ListNode cur = rec.get(key);
            cur.value = value;
            remove(cur);
            shift(cur);
        }
        else {
            if (rec.size() == capacity) {
                ListNode cur = tail.pre;
                remove(cur);
                rec.remove(cur.key);
            }
            
            ListNode cur = new ListNode(key, value);
            shift(cur);
            rec.put(key, cur);
        }
    }
    
    private void remove(ListNode cur) {
        ListNode pre = cur.pre;
        ListNode next = cur.next;
        pre.next = next;
        next.pre = pre;
    }
    
    private void shift(ListNode cur) {
        ListNode next = head.next;
        head.next = cur;
        cur.next = next;
        next.pre = cur;
        cur.pre = head;
    }
}