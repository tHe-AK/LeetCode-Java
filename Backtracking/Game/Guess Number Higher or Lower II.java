public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2];

        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int end = start + len - 1;
                int min = Integer.MAX_VALUE;
                
                for (int i = start; i <= end; i++) {
                    min = Math.min(result, i + Math.max(dp[start][i - 1], dp[i + 1][end]));
                }
                
                dp[start][end] = min;
            }

        }
        
        return dp[1][n];
    }
}

public class Solution {
    public int getMoneyAmount(int n) {
        int[][] rec = new int[n + 1][n + 1];
        
        return getMoneyAmount(1, n, rec);
    }
    
    private int getMoneyAmount(int start, int end, int[][] rec) {
        if (start >= end) {
            return 0;
        }
        
        if (rec[start][end] > 0) {
            return rec[start][end];
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i = start; i <= end; i++) {
            min = Math.min(min, i + Math.max(getMoneyAmount(start, i - 1, rec), getMoneyAmount(i + 1, end, rec)));
        }
        
        rec[start][end] = min;
        
        return min;
    }
}
