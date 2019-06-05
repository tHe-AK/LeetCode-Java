class Solution {
    public int shortestSubarray(int[] A, int K) {
        int N = A.length;
        int[] sum = new int[N + 1];
        
        for (int i = 0; i < N; i++) {
            sum[i + 1] = sum[i] + A[i];
        }
        
        Deque<Integer> deque = new LinkedList<>();
        int min = N + 1;
        
        for (int i = 0; i <= N; i++) {
            while (!deque.isEmpty() && sum[i] - sum[deque.peek()] >= K) {
                min = Math.min(min, i - deque.poll());
            }
            
            while (!deque.isEmpty() && sum[i] <= sum[deque.peekLast()] ) {
                deque.pollLast();
            }
            
            deque.offer(i);
        }
        
        return min <= N ? min : -1;
    }
}
