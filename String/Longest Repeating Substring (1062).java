class Solution {
    public int longestRepeatingSubstring(String S) {
        int N = S.length();
        int[][] dp = new int[N + 1][N + 1];
        int max = 0;
        
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (S.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        return max;
    }
}

class Solution {
    public int longestRepeatingSubstring(String S) {
        int N = S.length();
        int MOD = 1_000_000_007;
        int low = 1;
        int high = N - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isValid(S, mid, MOD)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return high;
    }
    
    private boolean isValid(String S, int N, int MOD) {
        Set<Long> visited = new HashSet<>();
        long num = 0;
        long pow = 1;
        
        for (int i = 0; i < S.length(); i++) {
            num = ((num * 26 % MOD) + S.charAt(i) - 'a') % MOD;
            
            if (i < N - 1) {
                pow = pow * 26 % MOD;
            } else {
               if (!visited.add(num)) {
                    return true;
                }
                
                num = (num - ((S.charAt(i - N + 1) - 'a') * pow % MOD) + MOD) % MOD;
            }
        }
        
        return false;
    }
}
