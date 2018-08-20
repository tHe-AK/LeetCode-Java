class Solution {
    public int cherryPickup(int[][] grid) {
        int N = grid.length;
        int[][] dp = new int[N][N];
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        dp[0][0] = grid[0][0];
        int[][] delta = { { -1, -1 }, { -1, 0 }, { 0, -1 }, { 0 , 0 } };
        
        for (int k = 1; k <= (N - 1) * 2; k++) {
            int[][] temp = new int[N][N];
            
            for (int[] row : temp) {
                Arrays.fill(row, -1);
            }
            
            for (int i = Math.max(k - N + 1, 0); i <= Math.min(k, N - 1); i++) {
                for (int j = Math.max(k - N + 1, 0); j <= Math.min(k, N - 1); j++) {
                    if (grid[i][k - i] != -1 && grid[j][k - j] != -1) {
                        int val = grid[i][k - i] + ((i != j) ? grid[j][k - j] : 0);
                        
                        for (int[] diff : delta) {
                            int x = i + diff[0];
                            int y = j + diff[1];
                            
                            if (x >= 0 && y >= 0 && dp[x][y] != -1) {
                                temp[i][j] = Math.max(temp[i][j], dp[x][y] + val);
                            }
                        }
                    }
                }
            }
            
            dp = temp;
        }
        
        return Math.max(dp[N - 1][N - 1], 0);
    }
}
