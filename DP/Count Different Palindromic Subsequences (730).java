class Solution {
    public int countPalindromicSubsequences(String S) {
        int N = 1000000007;
        int n = S.length();
        int[][] dp = new int[n][n];
        int[] prev = new int[n];
        int[] next = new int[n];
        int[] idx = new int[4];
        Arrays.fill(prev, -1);
        Arrays.fill(next, -1);
        Arrays.fill(idx, -1);
        
        for (int i = 0; i < n; i++) {
            int ch = S.charAt(i) - 'a';
            
            if (idx[ch] != -1) {
                prev[i] = idx[ch];
            }
            
            idx[ch] = i;
        }
        
        Arrays.fill(idx, -1);
        
        for (int i = n - 1; i >= 0; i--) {
            int ch = S.charAt(i) - 'a';
            
            if (idx[ch] != -1) {
                next[i] = idx[ch];
            }
            
            idx[ch] = i;
        }
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        
        for (int k = 1; k < n; k++) {
            for (int i = 0; i < n - k; i++) {
                int j = i + k;
                
                if (S.charAt(i) != S.charAt(j)) {
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                } else {
                    int left = next[i];
                    int right = prev[j];
                    
                    if (left > right) {
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                    } else if (left == right) {
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[left + 1][right - 1];
                    }
                }
                
                dp[i][j] = dp[i][j] >= 0 ? dp[i][j] % N : dp[i][j] + N;
            }
        }
        
        return dp[0][n - 1];
    }
}
