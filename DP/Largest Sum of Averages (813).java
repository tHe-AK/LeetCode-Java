class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int N = A.length;
        double[] sum = new double[N];
        double[] dp = new double[N];
        sum[0] = A[0];
        dp[0] = A[0];
        
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + A[i];
            dp[i] = sum[i] / (i + 1);
        }
        
        for (int k = 0; k < K - 1; k++) {
            for (int i = N - 1; i > k; i--) {
                for (int j = k; j < i; j++) {
                    dp[i] = Math.max(dp[i], dp[j] + (sum[i] - sum[j]) / (i - j));
                }
            }
        }
        
        return dp[N - 1];
    }
}
