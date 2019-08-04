class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        List<Integer>[] graph = new List[N];
        int[] res = new int[N];
        
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] path : paths) {
            int i = path[0] - 1;
            int j = path[1] - 1;
            graph[i].add(j);
            graph[j].add(i);
        }
        
        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[5];
            
            for (Integer j : graph[i]) {
                visited[res[j]] = true;
            }
            
            for (int j = 1; j <= 4; j++) {
                if (!visited[j]) {
                    res[i] = j;
                }
            }
        }
        
        return res;
    }
}
