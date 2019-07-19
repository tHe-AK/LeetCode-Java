class Solution {
    public int countTriplets(int[] A) {
        int M = 3;
        int N = 1 << 16;
        int[][] dp = new int[M + 1][N];
        dp[0][N - 1] = 1;
        
        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k : A) {
                    dp[i][j & k] += dp[i - 1][j];
                }
            }
        }
        
        return dp[M][0];
    }
}
