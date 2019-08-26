class Solution {
    public int maximumMinimumPath(int[][] A) {
        int M = A.length;
        int N = A[0].length;
        int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        Set<String> visited = new HashSet<>();
        pq.offer(new int[] { A[0][0], 0, 0 });
        visited.add("0 0");
        
        while (!pq.isEmpty()) {
            int[] peek = pq.poll();
            int max = peek[0];
            int i = peek[1];
            int j = peek[2];
            
            if (i == M - 1 && j == N - 1) {
                return max;
            }
            
            for (int[] diff : delta) {
                int x = i + diff[0];
                int y = j + diff[1];
                String str = x + " " + y;
                
                if (x >= 0 && x < M && y >= 0 && y < N && !visited.contains(str)) {
                    pq.offer(new int[] { Math.min(max, A[x][y]), x, y });
                    visited.add(str);
                }
            }
        }
        
        return -1;
    }
}
