class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = new List[n];
        
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }
        
        return dfs(graph, source, destination, new boolean[n]);
    }
    
    private boolean dfs(List<Integer>[] graph, int i, int destination, boolean[] visited) {
        if (visited[i]) {
            return false;
        }
        
        if (graph[i].isEmpty()) {
            return i == destination;
        }
        
        visited[i] = true;
        
        for (Integer j : graph[i]) {
            if (!dfs(graph, j, destination, visited)) {
                return false;
            }
        }
        
        visited[i] = false;
        return true;
    }
}
