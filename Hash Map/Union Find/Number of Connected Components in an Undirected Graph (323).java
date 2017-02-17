public class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(list, i, visited);
                count++;
            }
        }
        
        return count;
    }
    
    private void dfs(List<List<Integer>> list, int i, boolean[] visited) {
        visited[i] = true;
        
        for (int j : list.get(i)) {
            if (!visited[j]) {
                dfs(list, j, visited);
            }
        }
    }
}
