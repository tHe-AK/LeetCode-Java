class Solution {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int MOD = 1_000_000_007;
        int[][] dp = new int[G + 1][P + 1];
        dp[0][0] = 1;
        int ans = 0;
        
        for (int k = 0; k < group.length; k++) {
            int g = group[k];
            int p = profit[k];
            
            for (int i = G - g; i >= 0; i--) {
                for (int j = P; j >= 0; j--) {
                    int x = i + g;
                    int y = Math.min(j + p, P);
                    dp[x][y] = (dp[x][y] + dp[i][j]) % MOD;
                }
            }
        }
        
        for (int i = 1; i <= G; i++) {
            ans = (ans + dp[i][P]) % MOD;
        }
        
        return ans;
    }
}
