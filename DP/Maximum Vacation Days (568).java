public class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int[][] dp = new int[flights.length][days[0].length];
        
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return dfs(flights, days, 0, 0, dp);
    }
    
    private int dfs(int[][] flights, int[][] days, int n, int k, int[][] dp) {
        if (k == days[0].length) {
            return 0;
        }
        
        if (dp[n][k] > 0) {
            return dp[n][k];
        }
        
        int max = 0;
        
        for (int j = 0; j < flights.length; j++) {
            if (flights[n][j] == 1 || j == n) {
                max = Math.max(max, days[j][k] + dfs(flights, days, j, k + 1, dp));
            }
        }
        
        dp[n][k] = max;
        return max;
    }
}

public class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length;
        int k = days[0].length;
        int[][] dp = new int[n][k + 1];
        
        for (int j = k - 1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                dp[i][j] = days[i][j] + dp[i][j + 1];
        
                for (int x = 0; x < n; x++) {
                    if (flights[i][x] == 1) {
                        dp[i][j] = Math.max(dp[i][j], days[x][j] + dp[x][j + 1]);
                    }
                }
            }
        }
        
        return dp[0][0];
    }
}
