class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        boolean[][] graph = new boolean[N + 1][N + 1];
        int[] visited = new int[N + 1];

        for (int[] pair : dislikes) {
            int i = pair[0];
            int j = pair[1];
            graph[i][j] = true;
            graph[j][i] = true;
        }
        
        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0 && !dfs(graph, i, 1, visited)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(boolean[][] graph, int i, int color, int[] visited) {
        if (visited[i] != 0) {
            return visited[i] == color;
        }
        
        visited[i] = color;
        
        for (int j = 1; j < graph.length; j++) {
            if (graph[i][j] && !dfs(graph, j, -color, visited)) {
                return false;
            }
        }
        
        return true;
    }
}
