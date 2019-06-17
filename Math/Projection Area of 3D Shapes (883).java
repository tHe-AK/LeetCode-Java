class Solution {
    public int projectionArea(int[][] grid) {
        int N = grid.length;
        int ans = 0;
        
        for (int i = 0; i < N; i++) {
            int row = 0;
            int col = 0;
            
            for (int j = 0; j < N; j++) {
                if (grid[i][j] > 0) {
                    ans++;
                }
                
                row = Math.max(row, grid[i][j]);
                col = Math.max(col, grid[j][i]);
            }
            
            ans += row + col;
        }
        
        return ans;
    }
}
