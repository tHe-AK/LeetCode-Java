class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int M = A.length;
        int N = B.length;
        int dp[][] = new int[M + 1][N + 1];
        
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        
        return dp[M][N];
    }
}
