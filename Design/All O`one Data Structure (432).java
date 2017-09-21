class AllOne {
    private class ListNode {
        public int val;
        public Set<String> keySet;
        public ListNode pre;
        public ListNode next;

        public ListNode(int val, Set<String> keySet) {
            this.val = val;
            this.keySet = keySet;
        }
    }
    
    private ListNode head;
    private ListNode tail;
    private Map<String, ListNode> keyMap;

    /** Initialize your data structure here. */
    public AllOne() {
        head = new ListNode(0, new HashSet<>());
        tail = new ListNode(0, new HashSet<>());
        head.next = tail;
        tail.pre = head;
        keyMap = new HashMap<>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (keyMap.containsKey(key)) {
            ListNode curr = keyMap.get(key);
            insertNext(curr, key);
            keyMap.put(key, curr.next);
            remove(curr, key);
        } else {
            insertNext(head, key);
            keyMap.put(key, head.next);
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (keyMap.containsKey(key)) {
            ListNode curr = keyMap.get(key);
            
            if (curr.val > 1) {
                insertPre(curr, key);
                keyMap.put(key, curr.pre);
            } else {
                keyMap.remove(key);
            }
            
            remove(curr, key);
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return head.next == tail ? "" : tail.pre.keySet.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next == tail ? "" : head.next.keySet.iterator().next();
    }

    private void insertPre(ListNode curr, String key) {
        int val = curr.val - 1;
        ListNode pre = curr.pre;
        
        if (pre.val == val) {
            pre.keySet.add(key);
        } else {
            insert(pre, curr, key, val);
        }
    }
    
    private void insertNext(ListNode curr, String key) {
        int val = curr.val + 1;
        ListNode next = curr.next;
        
        if (next.val == val) {
            next.keySet.add(key);
        } else {
            insert(curr, next, key, val);
        }
    }
    
    private void insert(ListNode pre, ListNode next, String key, int val) {
        Set<String> keySet = new HashSet<String>();
        keySet.add(key);
        ListNode curr = new ListNode(val, keySet);
        pre.next = curr;
        curr.next = next;
        next.pre = curr;
        curr.pre = pre;
    }
    
    private void remove(ListNode curr, String key) {
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
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
