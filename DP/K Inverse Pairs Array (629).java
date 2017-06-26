public class Solution {
    public int kInversePairs(int n, int k) {
        int N = 1000000007;
        int[][] dp = new int[n + 1][k + 1];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else {
                    for (int x = 0; x <= Math.min(i - 1, j); x++) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - x]) % N;
                    }
                }
            }
        }
        
        return dp[n][k];
    }
}
