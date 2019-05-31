class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int N = quiet.length;
        List<Integer>[] graph = new List[N];
        int[] res = new int[N];
        Arrays.fill(res, -1);
        
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] pair : richer) {
            graph[pair[1]].add(pair[0]);
        }
        
        for (int i = 0; i < N; i++) {
            dfs(graph, quiet, i, res);
        }
        
        return res;
    }
    
    private void dfs(List<Integer>[] graph, int[] quiet, int i, int[] res) {
        if (res[i] > -1) {
            return;
        }
        
        res[i] = i;

        for (int j : graph[i]) {
            dfs(graph, quiet, j, res);
                
            if (quiet[res[j]] < quiet[res[i]]) {
                res[i] = res[j];
            }
        }
    }
}
