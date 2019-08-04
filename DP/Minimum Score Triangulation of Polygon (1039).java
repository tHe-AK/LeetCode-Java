class Solution {
    public int minScoreTriangulation(int[] A) {
        int N = A.length;
        int[][] dp = new int[N][N];
        
        for (int k = 2; k < N; k++) {
            for (int i = 0; i + k < N; i++) {
                int j = i + k;
                dp[i][j] = Integer.MAX_VALUE;
                
                for (int x = i + 1; x < j; x++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][x] + dp[x][j] + A[i] * A[x] * A[j]);
                }
            }
        }
        
        return dp[0][N - 1];
    }
}
