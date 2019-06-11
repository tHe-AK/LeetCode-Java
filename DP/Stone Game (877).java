class Solution {
    public boolean stoneGame(int[] piles) {
        return true;
    }
}

class Solution {
    public boolean stoneGame(int[] piles) {
        int N = piles.length;
        int[][] dp = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            dp[i][i] = piles[i];
        }
        
        for (int k = 1; k < N; k++) {
            for (int i = 0; i < N - k; i++) {
                int j = i + k;
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        
        return dp[0][N - 1] > 0;
    }
}

class Solution {
    public boolean stoneGame(int[] piles) {
        int N = piles.length;
        int[] dp = piles.clone();
        
        for (int k = 1; k < N; k++) {
            for (int i = 0; i < N - k; i++) {
                int j = i + k;
                dp[i] = Math.max(piles[i] - dp[i + 1], piles[j] - dp[i]);
            }
        }
        
        return dp[0] > 0;
    }
}
