class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Map<Integer, List<int[]>> graph = new HashMap<>();
        int max = 0;
        
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new ArrayList<>());
            graph.get(time[0]).add(new int[] { time[1], time[2] });
        }
        
        for (Integer key : graph.keySet()) {
            Collections.sort(graph.get(key), (a, b) -> Integer.compare(a[1], b[1]));
        }
        
        dfs(graph, K, 0, dist);

        for (int i = 1; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            } else {
                max = Math.max(max, dist[i]);
            }
        }
        
        return max;
    }
    
    private void dfs(Map<Integer, List<int[]>> graph, int i, int time, int[] dist) {
        if (time >= dist[i]) {
            return;
        }
        
        dist[i] = time;
        
        if (graph.containsKey(i)) {
            for (int[] neighbor : graph.get(i)) {
                dfs(graph, neighbor[0], time + neighbor[1], dist);
            }
        }
    }
}
