class Solution {
    public int numPermsDISequence(String S) {
        int MOD = 1_000_000_007;
        int N = S.length() + 1;
        int[][] dp = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            dp[0][i] = 1;
        }
        
        for (int i = 1; i < N; i++) {
            int curr = 0;
            
            if (S.charAt(i - 1) == 'D') {
                for (int j = N - i; j >= 1; j--) {
                    curr = (curr + dp[i - 1][j]) % MOD;
                    dp[i][j - 1] = curr;
                }
            } else {
                for (int j = 0; j < N - i; j++) {
                    curr = (curr + dp[i - 1][j]) % MOD;
                    dp[i][j] = curr;
                }
            }
        }
        
        return dp[N - 1][0];
    }
}

class Solution {
    public int numPermsDISequence(String S) {
        int MOD = 1_000_000_007;
        int N = S.length() + 1;
        int[] dp = new int[N];
        
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }
        
        for (int i = 1; i < N; i++) {
            int[] temp = new int[N];
            int curr = 0;

            if (S.charAt(i - 1) == 'D') {
                for (int j = N - i; j >= 1; j--) {
                    curr = (curr + dp[j]) % MOD;
                    temp[j - 1] = curr;
                }
            } else {
                for (int j = 0; j < N - i; j++) {
                    curr = (curr + dp[j]) % MOD;
                    temp[j] = curr;
                }
            }
            
            dp = temp;
        }
        
        return dp[0];
    }
}
