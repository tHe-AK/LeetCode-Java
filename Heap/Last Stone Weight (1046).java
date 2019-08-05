class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        
        for (int stone : stones) {
            pq.offer(stone);
        }
            
        for (int i = 0; i < stones.length - 1; i++) {
            pq.offer(pq.poll() - pq.poll());
        }
            
        return pq.poll();
    }
}
