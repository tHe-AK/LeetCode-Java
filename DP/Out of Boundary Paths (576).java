public class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        int M = 1000000007;
        int count = 0;
        int[][] dp = new int[m][n];
        dp[i][j] = 1;

        for (int k = 1; k <= N; k++) {
            int[][] temp = new int[m][n];
            
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (x == 0) {
                        count = (count + dp[x][y]) % M;
                    }
                                
                    if (x == m - 1) {
                        count = (count + dp[x][y]) % M;
                    }
                                
                    if (y == 0) {
                        count = (count + dp[x][y]) % M;
                    }
                                
                    if (y == n - 1) {
                        count = (count + dp[x][y]) % M;
                    }
                
                    temp[x][y] = (((x > 0 ? dp[x - 1][y] : 0) + (x < m - 1 ? dp[x + 1][y] : 0)) % M + ((y > 0 ? dp[x][y - 1] : 0) + (y < n - 1 ? dp[x][y + 1] : 0)) % M) % M;
                }
            }
            
            dp = temp;
        }
        
        return count;
    }
}

public class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        int M = 1000000007;
        int[][][] dp = new int[m][n][N + 1];
        
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                Arrays.fill(dp[x][y], -1);
            }
        }
        
        return findPaths(m, n, N, i, j, dp, M);
    }
    
    private int findPaths(int m, int n, int N, int i, int j, int[][][] dp, int M) {
        if (i < 0 || j < 0 || i == m || j == n) {
            return 1;
        }
        
        if (N == 0) {
            return 0;
        }
        
        if (dp[i][j][N] >= 0) {
            return dp[i][j][N];
        }
        
        dp[i][j][N] = findPaths(m, n, N - 1, i - 1, j, dp, M);
        dp[i][j][N] = (dp[i][j][N] + findPaths(m, n, N - 1, i + 1, j, dp, M)) % M;
        dp[i][j][N] = (dp[i][j][N] + findPaths(m, n, N - 1, i, j - 1, dp, M)) % M;
        dp[i][j][N] = (dp[i][j][N] + findPaths(m, n, N - 1, i, j + 1, dp, M)) % M;

        return dp[i][j][N];
    }
}
