class Solution {
    public int mergeStones(int[] stones, int K) {
        int N = stones.length;
        K--;
        
        if ((N - 1) % K != 0) {
            return -1;
        }
        
        int[] sum = new int[N + 1];
        int[][] dp = new int[N][N];
        
        for (int j = 0; j < N; j++) {
            sum[j + 1] = sum[j] + stones[j];
        }
        
        for (int k = K; k < N; k++) {
            for (int i = 0; i + k < N; i++) {
                int j = i + k;

                dp[i][j] = Integer.MAX_VALUE;

                for (int mid = i; mid < j; mid += K) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][mid] + dp[mid + 1][j]);
                }

                if ((j - i) % K == 0) {
                    dp[i][j] += sum[j + 1] - sum[i];
                }
            }
        }
        
        return dp[0][N - 1];
    }
}
