class Solution {
    public int shortestPathLength(int[][] graph) {
        int N = graph.length;
        
        if (N == 1) {
            return 0;
        }
        
        int[][] dist = new int[N][1 << N];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][1 << i] = 0;
            queue.offer(new int[] { i, 1 << i });
        }
        
        while (!queue.isEmpty()) {
            int[] peek = queue.poll();
            int node = peek[0];
            int curr = peek[1];
            int step = dist[node][curr] + 1;
            
            for (int child : graph[node]) {
                int next = curr | (1 << child);
                
                if (step < dist[child][next]) {
                    if (next == (1 << N) - 1) {
                        return step;
                    }
                    
                    dist[child][next] = step;
                    queue.offer(new int[] { child, next });
                }
            }
        }
        
        return -1;
    }
}
