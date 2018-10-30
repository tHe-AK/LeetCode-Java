class Solution {
    public boolean isBipartite(int[][] graph) {
        int size = graph.length;
        int[] visited = new int[size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (visited[i] == 0 && !dfs(graph, i, 1, visited)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean dfs(int[][] graph, int i, int color, int[] visited) {
        if (visited[i] != 0) {
            return visited[i] == color;
        }
        
        visited[i] = color;
        
        for (int j : graph[i]) {
            if (!dfs(graph, j, -color, visited)) {
                return false;
            }
        }
        
        return true;
    }
}
