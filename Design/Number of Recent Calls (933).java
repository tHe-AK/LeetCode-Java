class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        
        queue.offer(t);
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */

class RecentCounter {
    int[] ts;

    public RecentCounter() {
        ts = new int[3001];
    }
    
    public int ping(int t) {
        ts[t % 3001] = t;
        int count = 0;
        
        for (int i : ts) {
            if (i != 0 && i >= t - 3000) {
                count++;
            }
        }
        
        return count;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
