class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[] rows = new int[M];
        int[] cols = new int[N];
        int sum = 0;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                rows[i] = Math.max(rows[i], grid[i][j]);
                cols[j] = Math.max(cols[j], grid[i][j]);
            }
        }
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                sum += Math.min(rows[i], cols[j]) - grid[i][j];
            }
        }
        
        return sum;
    }
}
