class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] graph = new int[N + 1];
        
        for (int[] pair : trust) {
            graph[pair[0]]--;
            graph[pair[1]]++;
        }
        
        for (int i = 1; i <= N; i++) {
            if (graph[i] == N - 1) {
                return i;
            }
        }
        
        return -1;
    }
}
