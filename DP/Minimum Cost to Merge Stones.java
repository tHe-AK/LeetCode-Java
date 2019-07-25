class Solution {
    public int mergeStones(int[] stones) {
        int N = stones.length;
        int[] sum = new int[N + 1];
        int[][] dp = new int[N][N];
        
        for (int j = 0; j < N; j++) {
            sum[j + 1] = sum[j] + stones[j];
        }
        
        for (int k = 1; k < N; k++) {
            for (int i = 0; i + k < N; i++) {
                int j = i + k;

                dp[i][j] = Integer.MAX_VALUE;

                for (int mid = i; mid < j; mid++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][mid] + dp[mid + 1][j]);
                }

                dp[i][j] += sum[j + 1] - sum[i];
            }
        }
        
        return dp[0][N - 1];
    }
}
