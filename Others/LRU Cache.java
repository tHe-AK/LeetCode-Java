class ListNode {
    int key;
    int val;
    ListNode pre;
    ListNode next;
    
    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {
    private int capacity;
    private HashMap<Integer, ListNode> hashMap;
    private ListNode start;
    private ListNode end;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashMap = new HashMap<Integer, ListNode>();
        start = new ListNode(0, 0);
        end = new ListNode(0, 0);
        start.next = end;
        end.pre = start;
    }
    
    public int get(int key) {
        if (!hashMap.containsKey(key)) {
            return -1;
        }
         
        ListNode cur = hashMap.get(key);
        remove(cur);
        shift(cur);
        
        return cur.val;
    }
    
    public void set(int key, int value) {
        if (hashMap.containsKey(key)) {
            ListNode cur = hashMap.get(key);
            cur.val = value;
            remove(cur);
            shift(cur);
        }
        else {
            if (hashMap.size() == capacity) {
                hashMap.remove(end.pre.key);
                remove(end.pre);
            }
            
            ListNode cur = new ListNode(key, value);
            hashMap.put(key, cur);
            shift(cur);
        }
    }
    
    private void remove(ListNode cur) {
        ListNode pre = cur.pre;
        ListNode next = cur.next;
        
        pre.next = next;
        next.pre = pre;
    }
    
    private void shift(ListNode cur) {
        ListNode next = start.next;
        
        start.next = cur;
        cur.next = next;
        next.pre = cur;
        cur.pre = start;
    }
}
