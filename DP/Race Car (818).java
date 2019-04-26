class Solution {
    public int racecar(int target) {
        int[] dp = new int[target + 1];
        
        for (int i = 1; i <= target; i++) {
            int k = (int) (Math.log(i + 1) / Math.log(2));
            int low = (1 << k) - 1;
            int high = (1 << (k + 1)) - 1;
            
            if (low == i) {
                dp[i] = k;
                continue;
            }
            
            dp[i] = k + 2 + dp[high - i];
            
            for (int j = 0; j < k; j++) {
                dp[i] = Math.min(dp[i], k + j + 2 + dp[i - (low - ((1 << j) - 1))]);
            }
        }
        
        return dp[target];
    }
}
