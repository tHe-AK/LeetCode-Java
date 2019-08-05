class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int N = A.length;
        int[] dp = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            int max = 0;
            
            for (int k = 1; k <= K && i - k >= 0; k++) {
                max = Math.max(max, A[i - k]);
                dp[i] = Math.max(dp[i], dp[i - k] + max * k);
            }
        }
        
        return dp[N];
    }
}
