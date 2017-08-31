class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        
        if (n == 0) {
            return 0;
        }
        
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        
        for (int d = 1; d < n; d++) {
            for (int i = 0; i < n - d; i++) {
                int j = i + d;
                dp[i][j] = dp[i + 1][j] + 1;
                
                for (int k = i + 1; k <= j; k++) {
                    if (s.charAt(i) == s.charAt(k)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][k - 1] + dp[k][j]);
                    }
                }
            }
        }
        
        return dp[0][n - 1];
    }
}
