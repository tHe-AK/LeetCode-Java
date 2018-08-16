class MyHashSet {
    private long[] bits; 
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        bits = new long[1000001 >> 6 + 1];
    }
    
    public void add(int key) {
        int offset = key >> 6;
        bits[offset] |= 1L << key;
    }
    
    public void remove(int key) {
        int offset = key >> 6;
        bits[offset] &= ~(1L << key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int offset = key >> 6;
        return (bits[offset] & (1L << key)) != 0;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
