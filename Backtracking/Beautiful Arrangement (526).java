public class Solution {
    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        int[] count = new int[1];
        
        dfs(N, visited, count);
        
        return count[0];
    }
    
    private void dfs(int idx, boolean[] visited, int[] count) {
        if (idx == 0) {
            count[0]++;
            return;
        }
        
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i] && (i % idx == 0 || idx % i == 0)) {
                visited[i] = true;
                dfs(idx - 1, visited, count);
                visited[i] = false;
            }
        }
    }
}
