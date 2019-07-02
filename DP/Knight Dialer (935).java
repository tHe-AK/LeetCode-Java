class Solution {
    public int knightDialer(int N) {
        int MOD = 1_000_000_007;
        int[][] delta = new int[][] { { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 0, 3, 9 }, {}, { 0, 1, 7 }, { 2, 6 }, { 1, 3 }, { 2, 4 } };
        int[][] memo = new int[N + 1][10];
        int count = 0;
        
        for (int i = 0; i <= 9; i++) {
            count = (count + dfs(N, i, delta, memo, MOD)) % MOD;
        }
        
        return count;
    }
    
    private int dfs(int N, int i, int[][] delta, int[][] memo, int MOD) {
        if (N == 1) {
            return 1;
        }
        
        if (memo[N][i] > 0) {
            return memo[N][i];
        }
        
        int count = 0;
        
        for (int j : delta[i]) {
            count = (count + dfs(N - 1, j, delta, memo, MOD)) % MOD;
        }
        
        memo[N][i] = count;
        return count;
    }
}

class Solution {
    public int knightDialer(int N) {
        int MOD = 1_000_000_007;
        int[][] delta = new int[][] { { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 0, 3, 9 }, {}, { 0, 1, 7 }, { 2, 6 }, { 1, 3 }, { 2, 4 } };
        int[] dp = new int[10];
        Arrays.fill(dp, 1);
        int count = 0;
        
        for (int k = 1; k < N; k++) {
            int[] next = new int[10];
            
            for (int i = 0; i < 10; i++) {
                for (int j : delta[i]) {
                    next[j] = (next[j] + dp[i]) % MOD;
                }
            }
            
            dp = next;
        }
        
        for (int i : dp) {
            count = (count + i) % MOD;
        }
        
        return count;
    }
}
