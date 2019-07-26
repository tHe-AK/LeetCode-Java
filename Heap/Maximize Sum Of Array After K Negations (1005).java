class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        Queue<Integer> pq = new PriorityQueue<Integer>();
        int sum  = 0;

        for (int i : A) {
            pq.offer(i);
        }
        
        while (K-- > 0) {
            pq.offer(-pq.poll());
        }

        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        
        return sum;
    }
}
