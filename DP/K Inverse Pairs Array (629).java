public class Solution {
    public int kInversePairs(int n, int k) {
        int M = 1000000007;
        int[][] dp = new int[n + 1][k + 1];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    int val = (dp[i - 1][j] + M - ((j - i) >= 0 ? dp[i - 1][j - i] : 0)) % M;
                    dp[i][j] = (dp[i][j - 1] + val) % M;
                }
            }
        }
        
        return (dp[n][k] + M - (k > 0 ? dp[n][k - 1] : 0)) % M;
    }
}


public class Solution {
    public int kInversePairs(int n, int k) {
        int M = 1000000007;
        int[][] dp = new int[n + 1][k + 1];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else {
                    for (int x = Math.max(0, j - (i - 1)); x <= j; x++) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][x]) % M;
                    }
                }
            }
        }
        
        return dp[n][k];
    }
}
