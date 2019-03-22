class Solution {
    public int numTilings(int N) {
        int M = (int) 1e9 + 7;
        int len = Math.max(N, 3) + 1;
        int[] dp = new int[len];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        
        for (int i = 4; i <= N; i++) {
            dp[i] = ((dp[i - 1] * 2) % M + dp[i - 3]) % M;
        }
        
        return dp[N];
    }
}
