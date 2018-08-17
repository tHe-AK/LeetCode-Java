class MyHashMap {
    private class ListNode {
        public int key;
        public int val;
        public ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private ListNode[] table;
    private final int capacity = 1 << 10;

    /** Initialize your data structure here. */
    public MyHashMap() {
        table = new ListNode[capacity];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = getIdx(key);

        if (table[idx] == null) {
            table[idx] = new ListNode(key, value);
        } else if (table[idx].key == key) {
            table[idx].val = value;
        } else {
            ListNode prev = getPrev(table[idx], key);
            
            if (prev.next == null) {
                prev.next = new ListNode(key, value);
            } else {
                prev.next.val = value;
            }
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = getIdx(key);

        if (table[idx] == null) {
            return -1;
        } else if (table[idx].key == key) {
            return table[idx].val;
        } else {
            ListNode prev = getPrev(table[idx], key);
            
            if (prev.next == null) {
                return -1;
            } else {
                return prev.next.val;
            }
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = getIdx(key);

        if (table[idx] == null) {
            return;
        } else if (table[idx].key == key) {
            table[idx] = table[idx].next;
        } else {
            ListNode prev = getPrev(table[idx], key);
            
            if (prev.next != null) {
                prev.next = prev.next.next;
            }
        }
    }
    
    private int getIdx(int key) {
        return Integer.hashCode(key) % capacity;
    }
    
    private ListNode getPrev(ListNode head, int key) {
        ListNode prev = head;
        ListNode curr = prev.next;
        
        while (curr != null) {
            if (curr.key == key) {
                return prev;
            }
            
            prev = curr;
            curr = curr.next;
        }
        
        return prev;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
