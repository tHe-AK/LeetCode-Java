class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        dfs(graph, 0, curr, result);
        return result;
    }
    
    private void dfs(int[][] graph, int i, List<Integer> curr, List<List<Integer>> result) {
        if (i == graph.length - 1) {
            result.add(new ArrayList<>(curr));
        }
        
        for (int j : graph[i]) {
            curr.add(j);
            dfs(graph, j, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}
