public class Solution {
    public int maxCoins(int[] nums) {
        int len = nums.length + 2;
        int[] rec = new int[len];
        rec[0] = rec[len - 1] = 1;
        int[][] dp = new int[len][len];
        
        for (int i = 0; i < nums.length; i++) {
            rec[i + 1] = nums[i];
        }
        
        for (int delta = 2; delta < len; delta++) {
            for (int i = 0; i < len - delta; i++) {
                int j = i + delta;
                
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], rec[i] * rec[k] * rec[j] + dp[i][k] + dp[k][j]);
                }
            }
        }
        
        return dp[0][len - 1];
    }
}
