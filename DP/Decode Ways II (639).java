public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        
        if (n == 0) {
            return 0;
        }
        
        int N = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
        
        for (int i = 2; i <= n; i++) {
            char curr = s.charAt(i - 1);
            char prev = s.charAt(i - 2);
            
            if (curr == '*') {
                dp[i] = 9 * dp[i - 1] % N;
                
                if (prev == '1') {
                    dp[i] = (dp[i] + 9 * dp[i - 2] % N) % N;
                } else if (prev == '2') {
                    dp[i] = (dp[i] + 6 * dp[i - 2] % N) % N;
                } else if (prev == '*') {
                    dp[i] = (dp[i] + 15 * dp[i - 2] % N) % N;
                }
            } else {
                if (curr != '0') {
                    dp[i] = dp[i - 1];
                }
                
                if (prev == '1' || (prev == '2' && curr <= '6')) {
                    dp[i] = (dp[i] + dp[i - 2]) % N;
                } else if (prev == '*') {
                    dp[i] = (dp[i] + (curr <= '6' ? 2 : 1) * dp[i - 2] % N) % N;
                }
            }
        }
        
        return (int)dp[n];
    }
}
