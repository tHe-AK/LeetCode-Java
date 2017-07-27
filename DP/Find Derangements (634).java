public class Solution {
    public int findDerangement(int n) {
        int N = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = ((i - 1) % N) * ((dp[i - 1] + dp[i - 2]) % N) % N;
        }

        return (int) dp[n];
    }
}
