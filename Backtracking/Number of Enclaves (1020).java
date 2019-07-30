class Solution {
    public int numEnclaves(int[][] A) {
        int M = A.length;
        int N = A[0].length;
        int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        
        for (int i = 0; i < M; i++) {
            dfs(A, i, 0, delta);
            dfs(A, i, N - 1, delta);
        }
        
        for (int j = 0; j < N; j++) {
            dfs(A, 0, j, delta);
            dfs(A, M - 1, j, delta);
        }
        
        int count = 0;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == 1) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void dfs(int[][] A, int i, int j, int[][] delta) {
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length || A[i][j] == 0) {
            return;
        }
        
        A[i][j] = 0;
        
        for (int[] diff : delta) {
            dfs(A, i + diff[0], j + diff[1], delta);
        }
    }
}
