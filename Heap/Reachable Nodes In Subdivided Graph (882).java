class Solution {
    public int reachableNodes(int[][] edges, int M, int N) {
        int[][] graph = new int[N][N];
        boolean[] visited = new boolean[N];
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        queue.offer(new int[] { M, 0 });
        int res = 0;
        
        for (int[] array : graph) {
            Arrays.fill(array, -1);
        }
        
        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];
            graph[i][j] = edge[2];
            graph[j][i] = edge[2];
        }
        
        while (!queue.isEmpty()) {
            int[] peek = queue.poll();
            int m = peek[0];
            int i = peek[1];
            
            if (visited[i]) {
                continue;
            }
            
            visited[i] = true;
            res++;
            
            for (int j = 0; j < N; j++) {
                if (graph[i][j] != -1) {
                    if (!visited[j] && m > graph[i][j]) {
                        queue.offer(new int[] { m - graph[i][j] - 1, j });
                    }
                    
                    int min = Math.min(graph[i][j], m);
                    graph[j][i] -= min;
                    res += min;
                }
            }
        }
        
        return res;
    }
}
