class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int N = A.length;
        int[] res = new int[N];
        Arrays.sort(A);
        int low = 0;
        int high = N - 1;
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        
        for (int i = 0; i < N; i++) {
            queue.offer(new int[] { B[i], i });
        }
        
        while (!queue.isEmpty()) {
            int[] peek = queue.poll();
            int val = peek[0];
            int idx = peek[1];
            res[idx] = val < A[high] ? A[high--] : A[low++];
        }
        
        return res;
    }
}
