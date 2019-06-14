class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        int i = 0;
        
        while (dp[i][K] < N) {
            i++;
            
            for (int k = 1; k <= K; k++) {
                dp[i][k] = dp[i - 1][k - 1] + dp[i - 1][k] + 1;
            }
        }
        
        return i;
    }
}

class Solution {
    public int superEggDrop(int K, int N) {
        int[] dp = new int[K + 1];
        int i = 0;
        
        while (dp[K] < N) {
            i++;
            
            for (int k = K; k >= 1; k--) {
                dp[k] += dp[k - 1] + 1;
            }
        }
        
        return i;
    }
}
