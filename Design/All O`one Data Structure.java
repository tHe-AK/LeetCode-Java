class Node {
    int val;
    Set<String> keySet;
    Node pre;
    Node next;
    
    public Node(int val, Set<String> keySet) {
        this.val = val;
        this.keySet = keySet;
    }
}


public class AllOne {
    private Node head;
    private Node tail;
    private Map<String, Node> keyMap;

    /** Initialize your data structure here. */
    public AllOne() {
        head = new Node(0, new HashSet<String>());
        tail = new Node(Integer.MAX_VALUE, new HashSet<String>());
        head.next = tail;
        tail.pre = head;
        keyMap = new HashMap<String, Node>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (keyMap.containsKey(key)) {
            Node cur = keyMap.get(key);
            insertNext(cur, key, cur.val + 1);
            remove(cur, key);
        } else {
            insertNext(head, key, 1);
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (keyMap.containsKey(key)) {
            Node cur = keyMap.get(key);
            
            if (cur.val > 1) {
                insertPre(cur, key, cur.val - 1);
            } else {
                keyMap.remove(key);
            }
            
            remove(cur, key);
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

    private void insertPre(Node next, String key, int val) {
        Node pre = next.pre;
        
        if (pre.val == val) {
            pre.keySet.add(key);
            keyMap.put(key, pre);
        } else {
            insert(pre, next, key, val);
        }
    }
    
    private void insertNext(Node pre, String key, int val) {
        Node next = pre.next;
        
        if (next.val == val) {
            next.keySet.add(key);
            keyMap.put(key, next);
        } else {
            insert(pre, next, key, val);
        }
    }
    
    private void insert(Node pre, Node next, String key, int val) {
        Set<String> keySet = new HashSet<String>();
        keySet.add(key);
        Node cur = new Node(val, keySet);
        pre.next = cur;
        cur.next = next;
        next.pre = cur;
        cur.pre = pre;
        keyMap.put(key, cur);
    }
    
    private void remove(Node cur, String key) {
        cur.keySet.remove(key);
        
        if (cur.keySet.isEmpty()) {
            Node pre = cur.pre;
            Node next = cur.next;
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
