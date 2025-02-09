class ListNode {
    public int count;
    public Set<Integer> keySet;
    public ListNode pre;
    public ListNode next;
    
    public ListNode(int count, Set<Integer> keySet) {
        this.count = count;
        this.keySet = keySet;
    }
}

public class LFUCache {
    private ListNode head;
    private ListNode tail;
    private Map<Integer, Integer> valMap;
    private Map<Integer, ListNode> countMap;
    private int capacity;
    
    public LFUCache(int capacity) {
        head = new ListNode(0, new LinkedHashSet<>());
        tail = new ListNode(0, new LinkedHashSet<>());
        head.next = tail;
        tail.pre = head;
        valMap = new HashMap<>();
        countMap = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (valMap.containsKey(key)) {
            ListNode curr = countMap.get(key);
            insert(curr, key);
            remove(curr, key);
            return valMap.get(key);
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        
        if (valMap.containsKey(key)) {
            ListNode curr = countMap.get(key);
            insert(curr, key);
            remove(curr, key);
        } else {
            if (valMap.size() == capacity) {
                int min = head.next.keySet.iterator().next();
                remove(head.next, min);
                countMap.remove(min);
                valMap.remove(min);
            }
            
            insert(head, key);
        }
        
        valMap.put(key, value);
    }
    
    private void insert(ListNode curr, int key) {
        int count = curr.count + 1;
        ListNode next = curr.next;
        
        if (next.count == count) {
            next.keySet.add(key);
        } else {
            insert(curr, next, key, count);
        }
        
        countMap.put(key, curr.next);
    }
    
    private void insert(ListNode pre, ListNode next, int key, int count) {
        Set<Integer> keySet = new LinkedHashSet<>();
        keySet.add(key);
        ListNode curr = new ListNode(count, keySet);
        pre.next = curr;
        curr.next = next;
        next.pre = curr;
        curr.pre = pre;
    }
    
    private void remove(ListNode curr, int key) {
        curr.keySet.remove(key);
        
        if (curr.keySet.isEmpty()) {
            ListNode pre = curr.pre;
            ListNode next = curr.next;
            pre.next = next;
            next.pre = pre;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
