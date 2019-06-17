class Solution {
    public int surfaceArea(int[][] grid) {
        int N = grid.length;
        int ans = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] > 0) {
                    ans += grid[i][j] * 4 + 2;
                }
                
                if (i > 0) {
                    ans -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
                }
                
                if (j > 0) {
                    ans -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
                }
            }
        }
        
        return ans;
    }
}
