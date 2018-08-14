class KthLargest {
    private PriorityQueue<Integer> pq;
    private int capacity;
    
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        capacity = k;
        
        for (int num : nums) {
           update(num);
        }
    }
    
    public int add(int val) {
        update(val);
        return pq.peek();
    }
    
    private void update(int val) {
        pq.offer(val);
            
        if (pq.size() > capacity) {
            pq.poll();
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
