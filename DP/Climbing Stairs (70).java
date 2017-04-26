public class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n == 0 ? 2 : n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
}

public class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        
        int pre1 = 1;
        int pre2 = 1;
        int curr = 0;
        
        for (int i = 2; i <= n; i++) {
            curr = pre1 + pre2;
            pre1 = pre2;
            pre2 = curr;
        }
        
        return curr;
    }
}
