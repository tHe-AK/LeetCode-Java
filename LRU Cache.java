public class LRUCache {
    private int capacity;
    private HashMap<Integer, ListNode> hashMap;
    ListNode tail;
    ListNode head;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashMap = new HashMap<Integer, ListNode>();
        tail = new ListNode(0, 0);
        head = new ListNode(0, 0);
        tail.next = head;
        head.pre = tail;
    }
    
    public int get(int key) {
        if (hashMap.containsKey(key) == true) {
            ListNode cur = hashMap.get(key);
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
            update(cur);
            return cur.value;
        }
        
        return -1;
    }
    
    public void set(int key, int value) {
        ListNode cur = null;
        if (hashMap.containsKey(key) == true) {
            cur = hashMap.get(key);
            cur.value = value;
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
        }
        else {
            if (hashMap.size() == capacity) {
                hashMap.remove(tail.next.key);
                ListNode tail_next = tail.next.next;
                tail.next = tail_next;
                tail_next.pre = tail;
            }
            cur = new ListNode(key, value);
            hashMap.put(key, cur);
        }
        
        update(cur);
    }
    
    private void update(ListNode cur) {
        ListNode head_pre = head.pre;
        head_pre.next = cur;
        cur.next = head;
        head.pre = cur;
        cur.pre = head_pre;
    }
}

class ListNode {
    public int key;
    public int value;
    public ListNode pre;
    public ListNode next;
    
    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
        pre = null;
        next = null;
    }
}
