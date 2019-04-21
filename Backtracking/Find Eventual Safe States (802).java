class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;
        int[] visited = new int[N];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (dfs(i, graph, visited)) {
                res.add(i);
            }
        }

        return res;
    }

    private boolean dfs(int i, int[][] graph, int[] visited) {
        if (visited[i] != 0) {
            return visited[i] == 2;
        }

        visited[i] = 1;

        for (int node : graph[i]) {
            if (!dfs(node, graph, visited)) {
                return false;
            }
        }

        visited[i] = 2;
        return true;
    }
}
