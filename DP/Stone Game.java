public class Solution {
    public int stoneGame(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        int[][] sum = new int[len][len];
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            sum[i][i] = nums[i];
            
            for (int j = i + 1; j < len; j++) {
                sum[i][j] += sum[i][j - 1] + nums[j];
            }
        }
        
        for (int delta = 1; delta < len; delta++) {
            for (int i = 0; i < len - delta; i++) {
                int j = i + delta;
                dp[i][j] = Integer.MAX_VALUE;
                
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                }
                
                dp[i][j] += sum[i][j];
            }
        }
        
        return dp[0][len - 1];
    }
}
