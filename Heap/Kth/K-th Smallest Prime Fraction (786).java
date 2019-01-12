class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int N = A.length;
        Queue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> Double.compare(1.0 * A[a[0]] / A[a[1]], 1.0 * A[b[0]] / A[b[1]]));
        pq.offer(new int[] { 0, N - 1 });

        while (K-- > 1) {
            int[] peek = pq.poll();
            int i = peek[0];
            int j = peek[1];

            if (i + 1 < j) {
                if (j == N - 1) {
                    pq.offer(new int[] { i + 1, N - 1 });
                }
                
                pq.offer(new int[] { i, j - 1 });
            }
        }
        
        int[] peek = pq.peek();
        return new int[] { A[peek[0]], A[peek[1]] };
    }
}
